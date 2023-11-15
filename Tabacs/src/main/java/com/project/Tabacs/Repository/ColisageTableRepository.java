package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.Colisage;
import com.project.Tabacs.Model.ColisageTable;
import com.project.Tabacs.Model.RecapitulationLC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.Year;
import java.util.List;
import java.util.Optional;

public interface ColisageTableRepository extends JpaRepository<ColisageTable, Integer> {
    List<ColisageTable> findByColisageNumeroLC(String numeroLC);


    @Query("SELECT DISTINCT ct.recolte FROM ColisageTable ct WHERE ct.colisage.numeroLC = :numeroLC")
    List<Year> getRecolte(String numeroLC);
    @Query("SELECT DISTINCT ct.grades.nomGrade FROM ColisageTable ct WHERE ct.colisage.numeroLC = :numeroLC")
    List<String> getGrade(String numeroLC);
    @Query("SELECT SUM(ct.poidsBrute) as poidsBrute FROM ColisageTable ct WHERE ct.grades.nomGrade = :nomGrade AND ct.recolte = :recolte AND ct.colisage.numeroLC = :numeroLC")
    Double getPoidsBrute(String nomGrade,Year recolte, String numeroLC);
    @Query("SELECT COUNT(ct.numeroBalle) as nbBalle FROM ColisageTable ct WHERE ct.grades.nomGrade = :nomGrade AND ct.recolte = :recolte AND ct.colisage.numeroLC = :numeroLC")
    Integer getNbBalle(String nomGrade, Year recolte, String numeroLC);
    @Query("SELECT (SUM(ct.poidsBrute) - COUNT(ct.numeroBalle)) as poidsNet FROM ColisageTable ct WHERE ct.grades.nomGrade = :nomGrade AND ct.recolte = :recolte AND ct.colisage.numeroLC = :numeroLC")
    Double getPoidsNet(String nomGrade, Year recolte, String numeroLC);
    @Query("SELECT (ct.grades.prixUnitaire * (SUM(ct.poidsBrute) - COUNT(ct.numeroBalle))) as montant FROM ColisageTable ct WHERE ct.grades.nomGrade = :nomGrade AND ct.recolte = :recolte AND ct.colisage.numeroLC = :numeroLC GROUP BY ct.grades.prixUnitaire")
    Double getMontant(String nomGrade, Year recolte, String numeroLC);



    @Query("SELECT SUM(ct.poidsBrute) as poidsBrute FROM ColisageTable ct WHERE ct.recolte = :recolte")
    Double sommePBparRecolte(Year recolte);
    @Query("SELECT COUNT(ct.numeroBalle) as nbBalle FROM ColisageTable ct WHERE ct.recolte = :recolte")
    Integer sommeNBparRecolte(Year recolte);
    @Query("SELECT (SUM(ct.poidsBrute) - COUNT(ct.numeroBalle)) as poidsNet FROM ColisageTable ct WHERE ct.recolte = :recolte")
    Double sommePNparRecolte(Year recolte);



    @Query("SELECT SUM(ct.poidsBrute) as poidsBrute FROM ColisageTable ct WHERE ct.colisage.numeroLC = :numeroLC")
    Double sommePB(String numeroLC);
    @Query("SELECT COUNT(ct.numeroBalle) as nbBalle FROM ColisageTable ct WHERE ct.colisage.numeroLC = :numeroLC")
    Integer sommeNB(String numeroLC);
    @Query("SELECT (SUM(ct.poidsBrute) - COUNT(ct.numeroBalle)) as poidsNet FROM ColisageTable ct WHERE ct.colisage.numeroLC = :numeroLC")
    Double sommePN(String numeroLC);
    @Query("SELECT SUM(ct.grades.prixUnitaire * (SUM(ct.poidsBrute) - COUNT(ct.numeroBalle))) as montant FROM ColisageTable ct WHERE ct.colisage.numeroLC = :numeroLC GROUP BY ct.grades.prixUnitaire")
    Double sommeMontant(String numeroLC);
}
