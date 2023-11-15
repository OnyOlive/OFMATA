package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.Varietes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VarietesRepository extends JpaRepository<Varietes, Integer> {
    Optional <Varietes> findByNomVariete(String nomVariete);
    List<Varietes> findByNomVarieteContains(String nomVariete);
}
