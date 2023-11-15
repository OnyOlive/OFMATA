package com.project.Tabacs.Model;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
//@Builder
public class Zone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idZone;
    @Column(unique = true)
    private String nomZone;
}
