package com.project.Tabacs.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Year;


@Getter
@Setter
@Entity
@NoArgsConstructor
public class Bilans {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBilan;

    private Year annee;

    private String variete;
    private String nomSociete;
    private String grade;
    private Double poidsParSociete;
    private Double montantParGrade;
    private Double montantParSociete;
    private Double pourcentageParRapportPoidsTotalParSociete; //poidsTotalAnnuel
    private Double pourcentageParRapportVenteTotalParSociete; //MontantAnnuel

    private Double montantTotalParGrade;
    private Double poidsTotal;
    private Double montanTotal;
    private Double totalPourcentageParRapportPoidsTotal;
    private Double totalPourcentageParRapportVenteTotal;
}
