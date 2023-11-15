package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.SocieteClients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SocietesClientsRepository extends JpaRepository<SocieteClients, Integer> {
    Optional<SocieteClients> findSocieteClientsByNomSocieteAndSecteurSociete(String nomSociete, String secteurSociete);
    Optional<SocieteClients> findByNomSociete(String nomSociete);
    List<SocieteClients> findByNomSocieteContains(String nomSociete);
    @Query("SELECT s.secteurSociete FROM SocieteClients s WHERE s.nomSociete = :nomSociete ")
    String getSecteurSociete(String nomSociete);
}
