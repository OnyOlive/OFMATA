package com.project.Tabacs.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class RecapitulationLC {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idRecap;
    private Year recolte;
    private String nomGrade;
    private Integer nbBalle;
    private Double poidsBrute;
    private Double poidsNet;
    private Double montant;
    private Double prixUnitaire;

    @OneToMany
    private List<ColisageTable> colisageTable;
}
