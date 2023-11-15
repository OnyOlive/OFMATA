package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Bilans;
import com.project.Tabacs.Model.Facture;
import com.project.Tabacs.Model.RecapitulationLC;
import com.project.Tabacs.Repository.FactureRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
@AllArgsConstructor
public class BilanServiceImplement implements BilanService{
    private final FactureRepository factureRepository;

    @Override
    public Double getMontantTotalAnnuel(Year annee) {

        return null;
    }

    @Override
    public Double getPoidsTotalAnnuel(Year annee) {
        Double poidsTotalParAn = 0.0;
        List<RecapitulationLC> recapitulationLCList = factureRepository.getRecapFromFacture(annee);
        for(RecapitulationLC recap: recapitulationLCList) {
            poidsTotalParAn = poidsTotalParAn + recap.getPoidsBrute();
        }
        return poidsTotalParAn;
    }

    @Override
    public Double getPoidsParSociete(String nomSociete) {
        return null;
    }

    @Override
    public Double getMontantParSociete(String nomSociete) {
        return null;
    }

    @Override
    public Double getPourcentagePoidsParSociete(String nomSociete, Year annee) {
        Double pps = (100 * getPoidsParSociete(nomSociete)) / getPoidsTotalAnnuel(annee);
        return null;
    }

    @Override
    public Double getPourcentageMontantParSociete(String nomSociete, Year annee) {
        Double pms = (100 * getMontantParSociete(nomSociete)) / getMontantTotalAnnuel(annee);
        return null;
    }

    @Override
    public List<Bilans> genererBilanAnnuel(Year annee) {
        return null;
    }
}
