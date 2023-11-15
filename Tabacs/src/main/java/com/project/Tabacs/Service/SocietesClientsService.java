package com.project.Tabacs.Service;

import com.project.Tabacs.Model.SocieteClients;

import java.util.List;

public interface SocietesClientsService {
    SocieteClients creerClient(SocieteClients societeClients);
    List<SocieteClients> lire();
    SocieteClients modifierClient(Integer idSociete, SocieteClients societeClients);
    String supprimerClient(Integer idSociete);

    SocieteClients rechercherParID(Integer idSociete);
    List<SocieteClients> rechercherParSociete(String nomSociete);
}
