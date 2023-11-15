package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.Facture;
import com.project.Tabacs.Model.RecapitulationLC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface FactureRepository extends JpaRepository<Facture, String> {
    Optional<Facture> findByNumeroFacture(String numeroFacture);

    //selectionner toutes les clients qui ont acheté la variete
    @Query("SELECT f.autorisation.societeClients.nomSociete FROM Facture f WHERE f.autorisation.variete = :nomVariete")
    List<String> getAllSocieteByVariete(String nomVariete);

    //selectionner toutes les varietes vendues en une annee
    @Query("SELECT f.autorisation.variete FROM Facture f WHERE f.dateFacture = :annee")
    List<String> getAllVarietePerYear(Year annee);
    @Query("SELECT f.recapitulationLC FROM Facture f WHERE f.dateFacture = :annee")
    List<RecapitulationLC> getRecapFromFacture(Year annee);
}
