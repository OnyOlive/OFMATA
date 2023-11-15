package com.project.Tabacs.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
public class Autorisation {
    @Id
    @Column(length = 50)
    private String numeroAE;
    @ManyToOne
    @JoinColumn(name = "nomSociete")
    private SocieteClients societeClients;
    private String secteurSociete;
    private String variete;
    @ElementCollection
    @CollectionTable(name = "recoltes", joinColumns = @JoinColumn(name = "numeroAE"))
    @Column(name = "recolte")
    private List<Year> recoltes = new ArrayList<>();
    @ElementCollection
    @CollectionTable(name = "numeroLC", joinColumns = @JoinColumn(name = "numeroAE"))
    @Column(name = "num")
    private List<String> numeroLC = new ArrayList<>();
    private Double poids;
    private String immatriculation;
    private String destination;
    private Integer validite;
    private LocalDate departVehicule;
    private LocalDate dateAE;
}
