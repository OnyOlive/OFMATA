package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.Tabacs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface TabacsRepository extends JpaRepository<Tabacs, Integer> {
    /*@Query("SELECT SUM(t.poids) FROM Tabacs t WHERE t.grades.nomGrade = :nomGrade")
    Double sommePoidsparGrade(@Param("nomGrade") String nomGrade);

    @Query("SELECT SUM(t.poids) FROM Tabacs t WHERE t.grades.varietes.nomVariete = :nomVariete")
    Double sommePoidsparVariete(@Param("nomVariete") String nomVariete);

    @Query("SELECT SUM(t.poids) FROM Tabacs t WHERE t.magasins.nomMagasin = :nomMagasin")
    Double sommePoidsparMagasin(@Param("nomMagasin") String nomMagasin);

    @Query("SELECT SUM(t.poids) FROM Tabacs t WHERE t.recolte = :recolte")
    Double sommePoidsParRecolte(@Param("recolte") Integer recolte);


    List<Tabacs> findByDateDepot(LocalDate dateDepot);
    Optional <List<Tabacs>> findByRecolte(Integer recolte);
    Optional <List<Tabacs>> findByGradesNomGrade(String nomGrade);
    Optional <Tabacs> findByGrades_VarietesNomVariete(String nomVariete);
    Optional <Tabacs> findByMagasins_NomMagasin(String nomMagasin);
    Optional <List<Tabacs>> findByMagasins_Secteur_NomSecteur(String nomSecteur);*/
}
