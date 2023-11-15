package com.project.Tabacs.Service;

import com.project.Tabacs.Model.*;
import com.project.Tabacs.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class TabacsServiceImplement implements TabacsService{
    private final TabacsRepository tabacsRepository;
    /*private final MagasinsRepository magasinsRepository;
    private final GradesRepository gradesRepository;

    public Tabacs deposerTabacs(Tabacs tabacs) {
        Magasins magasin = magasinsRepository
                .findByNomMagasin(tabacs.getMagasins().getNomMagasin())
                .orElseThrow(() -> new RuntimeException("Magasin non existant"));
        //tabacs.setMagasins(magasin);

        Grades grades = gradesRepository
                .findByNomGrade(tabacs.getGrades().getNomGrade())
                .orElseThrow(() -> new RuntimeException("Grade non existant"));
        //tabacs.setGrades(grades);

        return tabacsRepository.save(tabacs);
    }*/

    @Override
    public List<Tabacs> lire() {
        return tabacsRepository.findAll();
    }

    /*@Override
    public List<Tabacs> rechercherParGrade(String nomGrade) {
        return tabacsRepository
                .findByGradesNomGrade(nomGrade)
                .orElseThrow(() -> new RuntimeException("Grade non trouvée"));
    }

    @Override
    public List<Tabacs> rechercherParVariete(String nomVariete) {
        return null;
    }

    @Override
    public List<Tabacs> rechercherParMagasin(String nomMagasin) {
        return null;
    }

    @Override
    public Double sommePoidsParGrade(String nomGrade) {
        return tabacsRepository.sommePoidsparGrade(nomGrade);
    }


    @Override
    public Double sommePoidsParRecolte(Integer recolte) {
        return tabacsRepository.sommePoidsParRecolte(recolte);
    }

    @Override
    public Double sommePoidsParVariete(String nomVariete) {
        return tabacsRepository.sommePoidsparVariete(nomVariete);
    }

    @Override
    public Double sommePoidsParMagasin(String nomMagasin) {
        return tabacsRepository.sommePoidsparMagasin(nomMagasin);
    }

    @Override
    public List<Tabacs> rechercherParRecolte(Integer recolte) {
        return null;
    }

    @Override
    public List<Tabacs> rechercherParDate(LocalDate dateDepot) {
        return tabacsRepository.findByDateDepot(dateDepot);
    }
    */
}
