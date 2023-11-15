package com.project.Tabacs.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Grades {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idGrade;
    @Column(length = 20,unique = true)
    private String nomGrade;
    private Double prixUnitaire;
    @ManyToOne
    @JoinColumn(name = "nomVariete")
    private Varietes varietes;
}
