package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Grades;
import com.project.Tabacs.Model.Varietes;
import com.project.Tabacs.Repository.GradesRepository;
import com.project.Tabacs.Repository.VarietesRepository;
import com.project.Tabacs.exception.EntityExistException;
import com.project.Tabacs.exception.EntityNotFound;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GradesServiceImplement implements GradesService{
    private final GradesRepository gradesRepository;
    private final VarietesRepository varietesRepository;

    @Override
    public Grades creerGrade(Grades grades) {
        try {
            Varietes varietes = varietesRepository
                    .findByNomVariete(grades.getVarietes().getNomVariete())
                    .orElseThrow(() -> new EntityNotFound("La variété n'existe pas, veuillez vérifier"));
            grades.setVarietes(varietes);
            return gradesRepository.save(grades);
        }
        catch (DataIntegrityViolationException e) {
            throw new EntityExistException(String.format("La grade %s existe déjà!", grades.getNomGrade()));
        }
    }
    @Override
    public List<Grades> lire() {
        return gradesRepository.findAll();
    }

    @Override
    public Grades modifierGrade(Integer idGrade, Grades grades) {
        return gradesRepository.findById(idGrade)
                .map(g ->{
                    g.setNomGrade(grades.getNomGrade());
                    g.setPrixUnitaire(grades.getPrixUnitaire());
                    return gradesRepository.save(grades);
                }).orElseThrow(() -> new EntityNotFound("Cette grade n'existe pas"));
    }

    @Override
    public String supprimerGrade(Integer idGrade) {
        gradesRepository.deleteById(idGrade);
        return "Grade supprimée avec succès";
    }
    @Override
    public List<Grades> rechercheGrade(String nomGrade) {
        return gradesRepository.findByNomGradeContains(nomGrade);
    }

    @Override
    public Grades rechercherParID(Integer idGrade) {
        return gradesRepository
                .findById(idGrade)
                .orElseThrow(()->new EntityNotFound("La grade n'existe pas"));
    }

    @Override
    public List<Grades> rechercheParVariete(String nomVariete) {
        return gradesRepository.findGradesByVarietesNomVariete(nomVariete);
    }


}
