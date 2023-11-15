package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Magasins;
import com.project.Tabacs.Model.Secteur;
import com.project.Tabacs.Model.Zone;
import com.project.Tabacs.Repository.MagasinsRepository;
import com.project.Tabacs.Repository.SecteurRepository;
import com.project.Tabacs.exception.EntityExistException;
import com.project.Tabacs.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class MagasinsServiceImplement implements MagasinsService{
    private final MagasinsRepository magasinsRepository;
    private final SecteurRepository secteurRepository;

    @Override
    public Magasins creerMagasins(Magasins magasins) {
        try {
            Secteur secteur = secteurRepository
                    .findByNomSecteur(magasins.getSecteur().getNomSecteur())
                    .orElseThrow(() -> new EntityNotFound("Le secteur n'existe pas, veuillez vérifier."));
            magasins.setSecteur(secteur);
            return magasinsRepository.save(magasins);
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityExistException(String.format("Le magasin %s existe déjà!", magasins.getNomMagasin()));
        }


    }

    @Override
    public List<Magasins> lire() {
        return magasinsRepository.findAll();
    }

    @Override
    public Magasins modifierMagasins(Integer idMagasin, Magasins magasins) {
        return magasinsRepository.findById(idMagasin)
                .map(m->{
                    m.setNomMagasin(magasins.getNomMagasin());
                    return  magasinsRepository.save(m);
                }).orElseThrow(() -> new EntityNotFound("Le magasin n'existe pas"));
    }

    @Override
    public String supprimerMagasins(Integer idMagasin) {
        magasinsRepository.deleteById(idMagasin);
        return "Magasin supprimé avec succès";
    }

    @Override
    public List<Magasins> rechercherMagasin(String nomMagasin) {
        return magasinsRepository.findByNomMagasinContains(nomMagasin);
    }

    @Override
    public List<Magasins> rechercherSecteur(String nomSecteur) {
        return magasinsRepository.findBySecteurNomSecteur(nomSecteur);
    }

    @Override
    public List<Magasins> rechercherZone(String nomZone) {
        return magasinsRepository.findBySecteur_Zone_NomZone(nomZone);
    }

    @Override
    public Magasins findByID(Integer idMagasin) {
        return magasinsRepository
                .findById(idMagasin)
                .orElseThrow(()->new EntityNotFound("Le magasin n'existe pas"));
    }

    @Override
    public Magasins find(String nomMagasin, String nomSecteur) {
        return magasinsRepository
                .findMagasinsByNomMagasinAndSecteurNomSecteur(nomMagasin, nomSecteur)
                .orElseThrow(()->new EntityNotFound("Le magasin et le secteur ne correspondent pas"));
    }
}
