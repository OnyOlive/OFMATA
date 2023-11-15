package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Varietes;
import com.project.Tabacs.Repository.VarietesRepository;
import com.project.Tabacs.exception.EntityExistException;
import com.project.Tabacs.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class VarietesServiceImplement implements VarietesService{
    private final VarietesRepository varietesRepository;
    @Override
    public Varietes creerVariete(Varietes varietes) {
        try {
            return varietesRepository.save(varietes);
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityExistException(String.format("La variété %s existe déjà!", varietes.getNomVariete()));
        }
    }

    @Override
    public List<Varietes> lire() {
        return varietesRepository.findAll();
    }

    @Override
    public Varietes modifierVariete(Integer idVariete, Varietes varietes) {
        return varietesRepository.findById(idVariete)
                .map(v ->{
                    v.setNomVariete(varietes.getNomVariete());
                    return varietesRepository.save(varietes);
                }).orElseThrow(() -> new EntityNotFound("Cette variété n'existe pas"));
    }

    @Override
    public String supprimerVariete(Integer idVariete) {
        varietesRepository.deleteById(idVariete);
        return "Variété supprimée avec succès";
    }

    @Override
    public Varietes findByID(Integer idVariete) {
        return varietesRepository
                .findById(idVariete)
                .orElseThrow(() -> new EntityNotFound("Cette variété n'existe pas"));
    }
    @Override
    public List<Varietes> findVariete(String nomVariete) {
        return varietesRepository.findByNomVarieteContains(nomVariete);
    }
}
