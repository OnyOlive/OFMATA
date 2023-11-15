package com.project.Tabacs.Controller;

import com.project.Tabacs.Model.Colisage;
import com.project.Tabacs.Model.ColisageTable;
import com.project.Tabacs.Model.RecapitulationLC;
import com.project.Tabacs.Model.RecapitulationResponse;
import com.project.Tabacs.Service.ColisageService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/colisage")
@AllArgsConstructor
public class ColisageController {
    private final ColisageService colisageService;

    @PostMapping("/createHeader")
    public Colisage create (@RequestBody Colisage colisage) {
        return colisageService.ajouterLCheader(colisage);
    }

    @PostMapping("/createTable")
    public ColisageTable create(@RequestBody ColisageTable colisageTable) {
        return colisageService.ajouterLCTable(colisageTable);
    }

    @GetMapping("/readHeader")
    public List<Colisage> read() {
        return colisageService.lire();
    }

    @GetMapping("/readLC")
    public List<Colisage> readLCwithTable() {
        return colisageService.afficherLCAvecTable();
    }

    @GetMapping("/readCol/{numeroLC}")
    public Colisage findColisage(@PathVariable String numeroLC) {
        return colisageService.rechercherParID(numeroLC);
    }

    @GetMapping("/readColisage")
    public List<ColisageTable> readColisage() {
        return colisageService.listerColisageTable();
    }

    @GetMapping("/readByNumLC/{numeroLC}")
    public List<ColisageTable> readLC(@PathVariable String numeroLC) {
        return colisageService.listByNumLC(numeroLC);
    }

    @GetMapping("/recap/{numeroLC}")
    public RecapitulationResponse getRecap(@PathVariable String numeroLC) {
        RecapitulationResponse recapitulationResponse = RecapitulationResponse.builder()
                .sommeNB(colisageService.getTotalNB(numeroLC))
                .sommePB(colisageService.getTotalPB(numeroLC))
                .sommePN(colisageService.getTotalPN(numeroLC))
                //.sommeMontant(colisageService.getTotalMontant(numeroLC))
                .build();
        recapitulationResponse.addRecap(colisageService.genererRecapitulationLC(numeroLC));
        return recapitulationResponse;
    }

    @GetMapping("/readColisageByNumLC/{numeroLC}")
    public List<Colisage> findColisageByNumLC(@PathVariable String numeroLC) {
        return colisageService.rechercherParNumLC(numeroLC);
    }

    @GetMapping("/readColisageByNumLP/{numeroLP}")
    public List<Colisage> findColisageByNumLP(@PathVariable Integer numeroLP) {
        return colisageService.rechercherParNumLP(numeroLP);
    }

    @GetMapping("/readColisageByDate/{dateLC}")
    public List<Colisage> findColisageByDate(@PathVariable LocalDate dateLC) {
        return colisageService.rechercherParDateLC(dateLC);
    }
}
