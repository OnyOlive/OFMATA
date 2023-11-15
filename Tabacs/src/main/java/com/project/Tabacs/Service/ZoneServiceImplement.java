package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Zone;
import com.project.Tabacs.Repository.ZoneRepository;
import com.project.Tabacs.exception.EntityExistException;
import com.project.Tabacs.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import lombok.Setter;
import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.sql.SQLDataException;
import java.sql.SQLException;
import java.util.List;

@Service
@AllArgsConstructor
public class ZoneServiceImplement implements ZoneService{
    private final ZoneRepository zoneRepository;

    @Override
    public List<Zone> lire() {
        return zoneRepository.findAll();
    }
    @Override
    public Zone ajouterZone(Zone zone) {
        try {
            return zoneRepository.save(zone);
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityExistException(String.format("La zone %s existe déjà!", zone.getNomZone()));
        }
    }
    @Override
    public Zone modifierZone(Integer idZone, Zone zone) {
        return zoneRepository.findById(idZone)
                .map(z -> {
                    z.setNomZone(zone.getNomZone());
                    return zoneRepository.save(zone);
                }).orElseThrow(() -> new EntityNotFound("Cette zone n'existe pas "));
    }
    @Override
    public String supprimerZone(Integer idZone) {
        zoneRepository.deleteById(idZone);
        return "zone supprimée avec succès";
    }
    @Override
    public List<Zone> rechercherZone(String nomZone) {
        return zoneRepository
                .findByNomZoneContains(nomZone)
                .orElseThrow(() -> new EntityNotFound("Cette zone n'existe pas"));
    }
    @Override
    public Zone rechercheParID(Integer idZone) {
        return zoneRepository
                .findById(idZone)
                .orElseThrow(() -> new EntityNotFound("Cette zone n'existe pas"));
    }
}
