package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.Colisage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.*;
import java.time.LocalDate;
import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface ColisageRepository extends JpaRepository<Colisage, String> {
    Optional <Colisage> findByNumeroLC(String numeroLC);
    List<Colisage> findByNumeroLCContains(String numeroLC);
    List<Colisage> findByNumeroLaissezPasser(Integer numeroLaissezPasser);
    List<Colisage> findByDateLC(LocalDate dateLC);
    @Query("SELECT c FROM Colisage c JOIN ColisageTable ct ON c.numeroLC = ct.colisage.numeroLC")
    List<Colisage> getColisagesWithTable();

    @Query("SELECT c.emballage FROM Colisage c WHERE c.numeroLC = :numeroLC")
    Year getEmballage(String numeroLC);

    @Query("SELECT c.varietes.nomVariete FROM Colisage c WHERE c.numeroLC = :numeroLC")
    String getVariete(String numeroLC);

    @Query("SELECT c.dateLC FROM Colisage c WHERE c.numeroLC = :numeroLC")
    LocalDate getDateLC(String numeroLC);

    @Query("SELECT c FROM Colisage c WHERE c.numeroLC = :numeroLC")
    Colisage getColisageByNumLC(String numeroLC);

    @Query("SELECT c.numeroLC FROM Colisage c WHERE c.numeroLC = :numeroLC")
    Optional<String> getNumLC(String numeroLC);

    @Query("SELECT c.magasins.nomMagasin FROM Colisage c WHERE c.numeroLC = :numeroLC")
    String getMagasin(String numeroLC);



    //Optional <Colisage> findByDateLC(LocalDate dateLC);
}
