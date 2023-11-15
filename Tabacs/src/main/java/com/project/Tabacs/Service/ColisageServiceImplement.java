package com.project.Tabacs.Service;

import com.project.Tabacs.Model.*;
import com.project.Tabacs.Repository.*;
import com.project.Tabacs.exception.EntityExistException;
import com.project.Tabacs.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class ColisageServiceImplement implements ColisageService{
    private final ColisageRepository colisageRepository;
    private final VarietesRepository varietesRepository;
    private final MagasinsRepository magasinsRepository;
    private final ColisageTableRepository colisageTableRepository;
    private final GradesRepository gradesRepository;

    @Override
    public Colisage ajouterLCheader(Colisage colisage) {
        try {
            int numeroLCCounter = 0;
            numeroLCCounter++;

            // Formatage du numéroLC avec des zéros à gauche pour atteindre la longueur désirée
            String numeroLC = String.format("%07d", numeroLCCounter);
            // Gérer le cas où le compteur dépasse 9999999
            if (numeroLCCounter > 9999999) {
                numeroLCCounter = 0;
            }
            colisage.setNumeroLC(numeroLC);

            Varietes varietes = varietesRepository
                    .findByNomVariete(colisage.getVarietes().getNomVariete())
                    .orElseThrow(() -> new EntityNotFound("La variété n'existe pas"));
            colisage.setVarietes(varietes);

            Magasins magasins = magasinsRepository
                    .findMagasinsByNomMagasinAndSecteurNomSecteur(colisage.getMagasins().getNomMagasin(), colisage.getSecteur())
                    .orElseThrow(() -> new EntityNotFound("Le magasin et le secteur n'existent pas ou ne correspondent pas"));
            colisage.setMagasins(magasins);

            colisage.setDateLC(LocalDate.now());

            if(colisage.getDestination().length() <= 5 ){
                throw new EntityNotFound("Veuillez vérifier le lieu de destination");
            }
            if(colisage.getLieuDepart().length() <= 5 ){
                throw new EntityNotFound("Veuillez vérifier le lieu de départ");
            }
            if(colisage.getNomChauffeur().length() <= 5 ){
                throw new EntityNotFound("Veuillez vérifier le nom du chauffeur");
            }
            if(colisage.getNumeroCamion().length() < 7){
                throw new EntityNotFound("Veuillez vérifier le numéro du camion");
            }

            return colisageRepository.save(colisage);
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityExistException(String.format("La laissez-passer N° %s existe déjà!", colisage.getNumeroLaissezPasser()));
        }
    }
    public ColisageTable ajouterLCTable(ColisageTable colisageTable) {
        Grades grade = gradesRepository
                .findGradesByVarietesNomVarieteAndNomGrade(colisageTable.getColisage().getVarietes().getNomVariete(), colisageTable.getGrades().getNomGrade())
                .orElseThrow(() -> new EntityNotFound("La grade n'existe pas"));
        colisageTable.setGrades(grade);

        Year emballage = colisageRepository.getEmballage(colisageTable.getColisage().getNumeroLC());

        //verifier recolte < emballage
        System.out.println("annee: "+ emballage);
        if(colisageTable.getRecolte().isAfter(emballage)){
            throw new EntityNotFound("L'année de récolte doit être inférieur à l'année d'emballage");
        }
        return colisageTableRepository.save(colisageTable);
    }
    @Override
    public List<Colisage> lire() {
        return colisageRepository.findAll();
    }
    @Override
    public List<Colisage> afficherLCAvecTable() {
        return colisageRepository.getColisagesWithTable();
    }
    @Override
    public List<ColisageTable> listerColisageTable() {
        return colisageTableRepository.findAll();
    }
    @Override
    public List<ColisageTable> listByNumLC(String numeroLC) {
        return colisageTableRepository.findByColisageNumeroLC(numeroLC);
    }
    @Override
    public Colisage rechercherParID(String numeroLC) {
        return colisageRepository
                .findByNumeroLC(numeroLC)
                .orElseThrow(() -> new EntityNotFound("Colisage non trouvé") );
    }
    @Override
    public List<Colisage> rechercherParNumLC(String numeroLC) {
        return colisageRepository.findByNumeroLCContains(numeroLC);
    }
    @Override
    public List<Colisage> rechercherParNumLP(Integer numeroLP) {
        return colisageRepository.findByNumeroLaissezPasser(numeroLP);
    }
    @Override
    public List<Colisage> rechercherParDateLC(LocalDate dateLC) {
        return colisageRepository.findByDateLC(dateLC);
    }
    @Override
    public List<RecapitulationLC> genererRecapitulationLC(String numeroLC) {
        List<Year> recolte = colisageTableRepository.getRecolte(numeroLC);
        List<String> grades =  colisageTableRepository.getGrade(numeroLC);
        List<RecapitulationLC> recapitulationLCList = new ArrayList<>();

        for(Year r: recolte){
            for(String g: grades) {
                RecapitulationLC recapitulationLC = new RecapitulationLC();

                Integer nbBalle = colisageTableRepository.getNbBalle(g,r, numeroLC);
                Double poidsBrute = colisageTableRepository.getPoidsBrute(g,r, numeroLC);
                Double poidsNet = colisageTableRepository.getPoidsNet(g,r, numeroLC);
                Double montant = colisageTableRepository.getMontant(g, r, numeroLC);
                Double prixUnitaire = gradesRepository.findPU(g);

                recapitulationLC.setRecolte(r);
                recapitulationLC.setNomGrade(g);
                recapitulationLC.setNbBalle(nbBalle);
                recapitulationLC.setPoidsBrute(poidsBrute);
                recapitulationLC.setPoidsNet(poidsNet);
                recapitulationLC.setMontant(montant);
                recapitulationLC.setPrixUnitaire(prixUnitaire);

                recapitulationLCList.add(recapitulationLC);
            }
        }
        return recapitulationLCList;
    }

    public Integer getTotalNB(String numeroLC) {
        return colisageTableRepository.sommeNB(numeroLC);
    }
    public Double getTotalPB(String numeroLC) {
        return colisageTableRepository.sommePB(numeroLC);
    }
    public Double getTotalPN(String numeroLC) {
        return colisageTableRepository.sommePN(numeroLC);
    }
}
