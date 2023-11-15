package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Magasins;
import com.project.Tabacs.Model.Secteur;
import com.project.Tabacs.Model.Zone;
import com.project.Tabacs.Repository.SecteurRepository;
import com.project.Tabacs.Repository.ZoneRepository;
import com.project.Tabacs.exception.EntityExistException;
import com.project.Tabacs.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SecteurServiceImplement implements SecteurService{
    private final SecteurRepository secteurRepository;
    private final ZoneRepository zoneRepository;
    @Override
    public List<Secteur> lire() {
        return secteurRepository.findAll();
    }

    @Override
    public Secteur ajouterSecteur(Secteur secteur) {
        try {
            Zone zone = zoneRepository
                    .findByNomZone(secteur.getZone().getNomZone())
                    .orElseThrow(() -> new EntityNotFound("La zone n'existe pas"));
            secteur.setZone(zone);
            return secteurRepository.save(secteur);
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityExistException(String.format("Le secteur %s existe déjà!", secteur.getNomSecteur()));
        }
    }

    @Override
    public Secteur modifierSecteur(Integer idSecteur, Secteur secteur) {
        return secteurRepository.findById(idSecteur)
                .map(s -> {
                    s.setNomSecteur(secteur.getNomSecteur());
                    s.setZone(secteur.getZone());
                    return secteurRepository.save(secteur);
                }).orElseThrow(() -> new EntityNotFound("Ce secteur n'existe pas"));
    }

    @Override
    public String supprimerSecteur(Integer idSecteur) {
        secteurRepository.deleteById(idSecteur);
        return "Secteur supprimé avec succès";
    }

    @Override
    public List<Secteur> rechercherParSecteur(String nomSecteur) {
        return secteurRepository.findByNomSecteurContains(nomSecteur);
    }

    @Override
    public List<Secteur> rechercherParZone(String nomZone) {
        return secteurRepository.findByZoneNomZone(nomZone);
    }

    @Override
    public Secteur findByID(Integer idSecteur) {
        return secteurRepository
                .findById(idSecteur)
                .orElseThrow(() -> new EntityNotFound("Ce secteur n'existe pas"));
    }
}
