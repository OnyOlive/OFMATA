package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Facture;

import java.time.Year;
import java.util.List;

public interface FactureService {
    List<Facture> readAll();
    Facture calcul(Facture facture);

    Facture findFacture(String numeroFacture);



}
