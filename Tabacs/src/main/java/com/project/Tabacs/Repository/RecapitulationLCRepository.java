package com.project.Tabacs.Repository;

import com.project.Tabacs.Model.RecapitulationLC;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface RecapitulationLCRepository extends JpaRepository<RecapitulationLC, Integer> {

    /*
    @Query("SELECT (recap.CRACT * SUM(recap.montant)) as montantCRACT  FROM RecapitulationLC recap")
    Double getMontantCRACT();

    @Query("SELECT (recap.CRACT * SUM(recap.montant)) + (SUM(recap.montant)) as totalHorsTVA  FROM RecapitulationLC recap")
    Double getTotalHTVA();

    @Query("SELECT ((recap.CRACT * SUM(recap.montant)) + (SUM(recap.montant))) * recap.TVA as MontantTVA  FROM RecapitulationLC recap")
    Double getMontantTVA();*/

    //@Query("SELECT (((recap.CRACT * SUM(recap.montant)) + (SUM(recap.montant))) * recap.TVA) + (recap.CRACT * SUM(recap.montant)) + (SUM(recap.montant))  as totalAvecTVA  FROM RecapitulationLC recap")
    //Double getTotalAvecTVA();

}
