package com.project.Tabacs.Model;

import com.project.Tabacs.Model.Colisage;
import com.project.Tabacs.Model.Grades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.Year;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
public class ColisageTable {
    @Id
    private Integer numeroBalle;
    private Year recolte;
    private Double poidsBrute;
    @ManyToOne
    @JoinColumn(name = "nomGrade")
    private Grades grades;
    @ManyToOne
    @JoinColumn(name = "numeroLC")
    private Colisage colisage;
}

