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
public class Magasins {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMagasin;
    @Column(length = 75, unique = true)
    private String nomMagasin;
    @ManyToOne
    @JoinColumn(name = "nomSecteur")
    private Secteur secteur;
}
