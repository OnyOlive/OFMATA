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
public class Varietes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVariete;
    @Column(length = 75, unique = true)
    private String nomVariete;
}
