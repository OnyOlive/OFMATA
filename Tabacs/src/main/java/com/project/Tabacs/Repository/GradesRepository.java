package com.project.Tabacs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Tabacs.Model.Grades;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface GradesRepository extends JpaRepository<Grades, Integer> {
    List<Grades> findByNomGradeContains(String nomGrade);
    Optional<Grades> findGradesByVarietesNomVarieteAndNomGrade(String nomVariete, String nomGrade);
    List<Grades> findGradesByVarietesNomVariete(String nomVariete);
    @Query("SELECT g.prixUnitaire FROM Grades g WHERE g.nomGrade = :nomGrade")
    Double findPU(String nomGrade);
    Optional <Grades> findByNomGrade(String nomGrade);
}
