package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Bilans;

import java.time.Year;
import java.util.List;

public interface BilanService {
    Double getMontantTotalAnnuel(Year annee);
    Double getPoidsTotalAnnuel(Year annee);
    Double getPoidsParSociete(String nomSociete);
    Double getMontantParSociete(String nomSociete);
    Double getPourcentagePoidsParSociete(String nomSociete, Year annee);
    Double getPourcentageMontantParSociete(String nomSociete, Year annee);
    List<Bilans> genererBilanAnnuel(Year annee);

}
