package com.project.Tabacs.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Year;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Colisage {
    @Id
    private String numeroLC;
    @Column(unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numeroLaissezPasser;
    @Column(length = 10)
    private String numeroCamion;
    @Column(length = 100)
    private String nomChauffeur;
    @Column(length = 75)
    private String lieuDepart;
    @Column(length = 75)
    private String destination;
    private Year emballage;
    private LocalDate dateLC;

    //private Integer recolte;
    @ManyToOne
    private Varietes varietes;
    @ManyToOne
    private Magasins magasins;
    private String secteur;

    //@ManyToOne
    //private Autorisation autorisation;
    @ManyToOne
    private Autorisation autorisation;
}