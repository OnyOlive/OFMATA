package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Varietes;

import java.util.List;

public interface VarietesService{
    Varietes creerVariete(Varietes varietes);
    List<Varietes> lire();
    Varietes modifierVariete(Integer idVariete, Varietes varietes);
    String supprimerVariete(Integer idVariete);
    Varietes findByID(Integer idVariete);

    List<Varietes> findVariete(String nomVariete);
}
