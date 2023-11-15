package com.project.Tabacs.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Facture {
    @Id
    private String numeroFacture;
    @OneToOne
    @JoinColumn(name = "numeroAE")
    private Autorisation autorisation;
    private String magasin;
    @OneToMany
    private List<RecapitulationLC> recapitulationLC;
    private Integer sommeNB;
    private Double sommePB;
    private Double sommeMontant;

    private final Double CRACT = 0.05; // 5%
    private Double montantCRACT;
    private Double montantTotalAvecCRACT;

    private final Double TVA = 0.2; // 20%
    private Double montantTVA;
    private Double montantTotalAvecTVA;

    private Double transport;
    private Double totalFacture;

    private LocalDate dateFacture;
}
