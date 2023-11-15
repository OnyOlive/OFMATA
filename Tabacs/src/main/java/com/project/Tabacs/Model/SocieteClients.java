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
public class SocieteClients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSociete;
    @Column(length = 75, unique = true)
    private String nomSociete;
    @Column(length = 75)
    private String secteurSociete;
}
