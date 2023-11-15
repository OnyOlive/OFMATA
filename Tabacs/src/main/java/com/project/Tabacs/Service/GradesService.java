package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Grades;

import java.util.List;
import java.util.Optional;

public interface GradesService {
    Grades creerGrade(Grades grades);
    List<Grades> lire();
    Grades modifierGrade(Integer idGrade, Grades grades);
    String supprimerGrade(Integer idGrade);
    List<Grades> rechercheGrade(String nomGrade);
    Grades rechercherParID(Integer idGrade);
    List<Grades> rechercheParVariete(String nomVariete);
}
