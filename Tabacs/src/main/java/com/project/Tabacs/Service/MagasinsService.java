package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Magasins;
import java.util.List;

public interface MagasinsService {

    Magasins creerMagasins(Magasins magasins);
    List<Magasins> lire();
    Magasins modifierMagasins(Integer idMagasin, Magasins magasins);
    String supprimerMagasins(Integer idMagasin);
    List<Magasins> rechercherMagasin(String nomMagasin);
    List<Magasins> rechercherSecteur(String nomSecteur);
    List<Magasins> rechercherZone(String nomZone);
    Magasins findByID(Integer idMagasin);
    Magasins find(String nomMagasin, String nomSecteur);
}
