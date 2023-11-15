package com.project.Tabacs.Model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
public class Secteur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSecteur;
    @Column(unique = true)
    private String nomSecteur;
    @ManyToOne
    @JoinColumn(name = "nomZone")
    private Zone zone;
}
