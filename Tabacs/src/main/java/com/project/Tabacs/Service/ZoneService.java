package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Zone;

import java.util.List;

public interface ZoneService {
    List<Zone> lire();
    Zone ajouterZone(Zone zone);
    Zone modifierZone(Integer idZone, Zone zone);
    String supprimerZone(Integer idZone);
    List<Zone> rechercherZone(String nomZone);

    Zone rechercheParID(Integer idZone);
}
