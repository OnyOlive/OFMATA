package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.Autorisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorisationRepository extends JpaRepository<Autorisation, String> {
    Optional<Autorisation> findByNumeroAE(String numeroAE);


}
