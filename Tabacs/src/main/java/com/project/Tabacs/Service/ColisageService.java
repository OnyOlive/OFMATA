package com.project.Tabacs.Service;

import com.project.Tabacs.Model.ColisageTable;
import com.project.Tabacs.Model.Colisage;
import com.project.Tabacs.Model.RecapitulationLC;

import java.time.LocalDate;
import java.util.List;

public interface ColisageService {
    Colisage ajouterLCheader(Colisage colisage);
    ColisageTable ajouterLCTable(ColisageTable colisageTable);
    List<Colisage> lire();
    List<Colisage> afficherLCAvecTable();
    List<ColisageTable> listerColisageTable();
    List<ColisageTable> listByNumLC(String numeroLC);
    List<RecapitulationLC> genererRecapitulationLC(String numeroLC);
    Colisage rechercherParID(String numeroLC);
    List<Colisage> rechercherParNumLC(String numeroLC);
    List<Colisage> rechercherParNumLP(Integer numeroLP);
    List<Colisage> rechercherParDateLC(LocalDate dateLC);

    Integer getTotalNB(String numeroLC);
    Double getTotalPB(String numeroLC);
    Double getTotalPN(String numeroLC);
    //Double getTotalMontant(String numeroLC);

}
