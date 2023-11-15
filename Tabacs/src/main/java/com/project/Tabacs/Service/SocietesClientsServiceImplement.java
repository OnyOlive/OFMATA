package com.project.Tabacs.Service;

import com.project.Tabacs.Model.SocieteClients;
import com.project.Tabacs.Repository.SocietesClientsRepository;
import com.project.Tabacs.exception.EntityExistException;
import com.project.Tabacs.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SocietesClientsServiceImplement implements SocietesClientsService{
    private final SocietesClientsRepository societesClientsRepository;
    @Override
    public SocieteClients creerClient(SocieteClients societeClients) {
        try {
            return societesClientsRepository.save(societeClients);
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityExistException(String.format("La societe %s existe déjà!", societeClients.getNomSociete()));
        }
    }

    @Override
    public List<SocieteClients> lire() {
        return societesClientsRepository.findAll();
    }

    @Override
    public SocieteClients modifierClient(Integer idSociete, SocieteClients societeClients) {
        return societesClientsRepository.findById(idSociete)
                .map(s ->{
                    s.setNomSociete(societeClients.getNomSociete());
                    s.setSecteurSociete(societeClients.getSecteurSociete());
                    return societesClientsRepository.save(societeClients);
                }).orElseThrow(() -> new EntityNotFound("Cette société n'existe pas"));
    }

    @Override
    public String supprimerClient(Integer idSociete) {
        societesClientsRepository.deleteById(idSociete);
        return "Société supprimée avec succès";
    }

    @Override
    public SocieteClients rechercherParID(Integer idSociete) {
        return societesClientsRepository
                .findById(idSociete)
                .orElseThrow(() -> new EntityNotFound("Cette société n'existe pas"));
    }

    @Override
    public List<SocieteClients> rechercherParSociete(String nomSociete) {
        return societesClientsRepository.findByNomSocieteContains(nomSociete);
    }
}
