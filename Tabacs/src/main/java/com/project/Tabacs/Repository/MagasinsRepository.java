package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.Magasins;
import com.project.Tabacs.Model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MagasinsRepository extends JpaRepository<Magasins, Integer> {

    List<Magasins> findByNomMagasinContains(String nomMagasin);
    Optional<Magasins> findByNomMagasin(String nomMagasin);
    List<Magasins> findBySecteurNomSecteur(String nomSecteur);
    List<Magasins> findBySecteur_Zone_NomZone(String nomZone);
    Optional<Magasins> findByIdMagasin(Integer idMagasin);
    Optional<Magasins> findMagasinsByNomMagasinAndSecteurNomSecteur(String nomMagasin, String nomSecteur);
}
