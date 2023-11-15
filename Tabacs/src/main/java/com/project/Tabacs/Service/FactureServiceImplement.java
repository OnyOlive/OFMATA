package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Autorisation;
import com.project.Tabacs.Model.Colisage;
import com.project.Tabacs.Model.Facture;
import com.project.Tabacs.Model.RecapitulationLC;
import com.project.Tabacs.Repository.*;
import com.project.Tabacs.exception.EntityExistException;
import com.project.Tabacs.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FactureServiceImplement implements FactureService{
    private final FactureRepository factureRepository;
    private final ColisageTableRepository colisageTableRepository;
    private final ColisageRepository colisageRepository;
    private final AutorisationRepository autorisationRepository;
    private final RecapitulationLCRepository recapitulationLCRepository;
    private final  GradesRepository gradesRepository;
    @Override
    public List<Facture> readAll() {
        return factureRepository.findAll();
    }

    @Override
    public Facture calcul(Facture facture) {
        try {
            Autorisation autorisation = autorisationRepository
                    .findByNumeroAE(facture.getAutorisation().getNumeroAE())
                    .orElseThrow(() -> new EntityNotFound(String.format("L'autorisation portant le numero %s n'existe  pas", facture.getAutorisation().getNumeroAE())));
            facture.setAutorisation(autorisation);

            String magasin = null;
            String nomMagasin = null;

            Integer totalNB = 0;
            Double totalPB = 0.0;
            Double totalMontant = 0.0;

            Double montantCRACT = 0.0;
            Double montantTotalAvecCRACT = 0.0;
            Double montantTVA = 0.0;
            Double montantTotalAvecTVA = 0.0;

            Double totalFacture = 0.0;

            List<RecapitulationLC> recapitulationLCList = new ArrayList<>();
            List<String> ListnumeroLC = facture.getAutorisation().getNumeroLC();

            for (String num : ListnumeroLC) {
                //verifier que LC ont la meme provenance
                Colisage colisage = colisageRepository.getColisageByNumLC(num);
                nomMagasin = colisage.getMagasins().getNomMagasin();
                magasin = colisageRepository.getMagasin(num);
                if (!magasin.equals(nomMagasin)) {
                    throw new EntityNotFound("Les listes de colisage dans une facture doivent avoir la même provenance.");
                }

                //Generer recapitulation de(s) LC dans un facture
                List<Year> listRecolte = facture.getAutorisation().getRecoltes();
                List<String> grades = colisageTableRepository.getGrade(num);
                for (Year r : listRecolte) {
                    for (String g : grades) {
                        RecapitulationLC recapitulationLC = new RecapitulationLC();

                        Integer nbBalle = colisageTableRepository.getNbBalle(g, r, num);
                        Double poidsBrute = colisageTableRepository.getPoidsBrute(g, r, num);
                        Double poidsNet = colisageTableRepository.getPoidsNet(g, r, num);
                        Double montant = colisageTableRepository.getMontant(g, r, num);
                        Double prixUnitaire = gradesRepository.findPU(g);

                        if (nbBalle != 0) {
                            recapitulationLC.setRecolte(r);
                            recapitulationLC.setNomGrade(g);
                            recapitulationLC.setNbBalle(nbBalle);
                            recapitulationLC.setPoidsBrute(poidsBrute);
                            recapitulationLC.setPoidsNet(poidsNet);
                            recapitulationLC.setMontant(montant);
                            recapitulationLC.setPrixUnitaire(prixUnitaire);

                            recapitulationLCList.add(recapitulationLCRepository.save(recapitulationLC));

                            totalMontant = totalMontant.doubleValue() + recapitulationLC.getMontant().doubleValue();
                        }
                    }
                }
                totalNB = totalNB + colisageTableRepository.sommeNB(num);
                totalPB = totalPB + colisageTableRepository.sommePB(num);
            }

            montantCRACT = totalMontant * facture.getCRACT();
            montantTotalAvecCRACT = totalMontant + montantCRACT;
            montantTVA = montantTotalAvecCRACT * facture.getTVA();
            montantTotalAvecTVA = montantTotalAvecCRACT + montantTVA;
            totalFacture = montantTotalAvecTVA + facture.getTransport();

            facture.setSommeNB(totalNB);
            facture.setSommePB(totalPB);
            facture.setSommeMontant(totalMontant);
            facture.setMontantCRACT(montantCRACT);
            facture.setMontantTotalAvecCRACT(montantTotalAvecCRACT);
            facture.setMontantTVA(montantTVA);
            facture.setMontantTotalAvecTVA(montantTotalAvecTVA);
            facture.setTotalFacture(totalFacture);
            facture.setRecapitulationLC(recapitulationLCList);
            facture.setMagasin(nomMagasin);
            facture.setDateFacture(LocalDate.now());

            return factureRepository.save(facture);
        } catch (DataIntegrityViolationException e) {
            throw new EntityExistException(String.format("La facture correspondant à l'autorisation d'enlèvement N° %s existe déjà!", facture.getAutorisation().getNumeroAE()));
        }
    }

    @Override
    public Facture findFacture(String numeroFacture) {
        return factureRepository
                .findByNumeroFacture(numeroFacture)
                .orElseThrow(() -> new EntityNotFound(String.format("La facture portant le numéro %s n'existe pas",numeroFacture)));
    }
}
