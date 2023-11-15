package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Secteur;

import java.util.List;

public interface SecteurService {
    List<Secteur> lire();
    Secteur ajouterSecteur(Secteur secteur);
    Secteur modifierSecteur(Integer idSecteur, Secteur secteur);
    String supprimerSecteur(Integer idSecteur);
    List<Secteur> rechercherParSecteur(String nomSecteur);
    List<Secteur> rechercherParZone(String nomZone);
    Secteur findByID(Integer idSecteur);
}
