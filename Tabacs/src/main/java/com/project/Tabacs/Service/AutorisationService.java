package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Autorisation;

import java.util.List;
import java.util.Optional;

public interface AutorisationService {
    Autorisation creerAE(Autorisation autorisation);
    List<Autorisation> lire();
    Autorisation rechercherParID(String numeroAE);

}
