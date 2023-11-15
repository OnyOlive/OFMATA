package com.project.Tabacs.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Tabacs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTabac;
    private Double poids;
    private Integer recolte;
    private LocalDate dateDepot;

    /*@OneToOne
    private Grades grades;

    @OneToOne
    private Magasins magasins;*/
}
