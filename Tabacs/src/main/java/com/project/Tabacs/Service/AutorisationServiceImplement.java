package com.project.Tabacs.Service;

import com.project.Tabacs.Model.*;
import com.project.Tabacs.Repository.*;
import com.project.Tabacs.exception.EntityExistException;
import com.project.Tabacs.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AutorisationServiceImplement implements AutorisationService{
    private final AutorisationRepository autorisationRepository;
    private final SocietesClientsRepository societesClientsRepository;
    private final ColisageRepository colisageRepository;
    private final ColisageTableRepository colisageTableRepository;

    @Override
    public Autorisation creerAE(Autorisation autorisation) {
        //verifier si societe existe dans la table societe
        SocieteClients societeClients = societesClientsRepository
                .findByNomSociete(autorisation.getSocieteClients().getNomSociete())
                .orElseThrow(() -> new EntityNotFound("La société n'existe pas dans la liste des clients"));
        autorisation.setSocieteClients(societeClients);

        String secteur = societesClientsRepository.getSecteurSociete(autorisation.getSocieteClients().getNomSociete());
        autorisation.setSecteurSociete(secteur);

        String nomVariete = null;
        String variete = null;
        LocalDate date = null;
        LocalDate dateLC = null;
        Double totalPoids = 0.0;
        List<Year> recolteList = new ArrayList<>();
        List<String> numeroLCList = autorisation.getNumeroLC();
        List<Autorisation> listAutorisation = autorisationRepository.findAll();

        for(String num: numeroLCList) {
            //verifier que les numeroLC ne se repetent pas dans autorisations
            for(Autorisation a: listAutorisation) {
                for(String numero: a.getNumeroLC()){
                    if(num.equals(numero)){
                        throw new EntityExistException(String.format("L'autorisation correspondant à la liste de colisage N° %s existe déja",num));
                    }
                }
            }

            //verifier si numeroLC existe dans colisage
            var n = colisageRepository
                    .getNumLC(num)
                    .orElseThrow(()-> new EntityNotFound(String.format("La liste de colisage N° %s n'existe pas", num)));

            //verifier les recoltes
            List<Year> recolte = colisageTableRepository.getRecolte(n);
            recolteList.addAll(recolte);

            //verifier que LC ont la meme variete
            Colisage colisage = colisageRepository.getColisageByNumLC(n);

            nomVariete = colisage.getVarietes().getNomVariete();
            variete = colisageRepository.getVariete(n);
            if (!variete.equals(nomVariete)) {
                throw new EntityNotFound("Les listes de colisage dans une autorisation doivent avoir la même variété.");
            }

            //poids : somme des poids dans les listes de colisage
            totalPoids = totalPoids + colisageTableRepository.sommePB(n);

            //verifier si LC ont la meme date
            date = colisage.getDateLC();
            dateLC = colisageRepository.getDateLC(n);
            if(!dateLC.equals(date)){
                throw new EntityNotFound("Les listes de colisage dans une autorisation doivent avoir la même date.");
            }
        }

        autorisation.setNumeroLC(numeroLCList);
        autorisation.setVariete(nomVariete);
        autorisation.setRecoltes(recolteList);
        autorisation.setPoids(totalPoids);
        autorisation.setDateAE(LocalDate.now());

        //verifier que dateAE < dateDepart
        if(!autorisation.getDateAE().isBefore(autorisation.getDepartVehicule())){
            throw new RuntimeException("La date de départ du véhicule doit être ultérieure à la date de l'autorisation");
        }

        if(autorisation.getDestination().length() <= 5 ){
            throw new EntityNotFound("Veuillez vérifier la destination");
        }
        if(autorisation.getImmatriculation().length() < 7){
            throw new EntityNotFound("Veuillez vérifier l'immatriculation de la voiture");
        }

        return autorisationRepository.save(autorisation);
    }

    @Override
    public List<Autorisation> lire() {
        return autorisationRepository.findAll();
    }

    @Override
    public Autorisation rechercherParID(String numeroAE) {
        return autorisationRepository
                .findByNumeroAE(numeroAE)
                .orElseThrow(() -> new EntityNotFound(String.format("L'autorisation portant le numero %s n'existe  pas",numeroAE)));
    }
}
