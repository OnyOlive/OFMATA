package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SecteurRepository extends JpaRepository<Secteur, Integer> {
    List<Secteur> findByNomSecteurContains(String nomSecteur);
    List<Secteur> findByZoneNomZone(String nomZone);
    Optional<Secteur> findByNomSecteur(String nomSecteur);
}
