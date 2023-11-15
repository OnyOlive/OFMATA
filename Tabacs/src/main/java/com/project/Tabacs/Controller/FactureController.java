package com.project.Tabacs.Controller;

import com.project.Tabacs.Model.Facture;
import com.project.Tabacs.Service.FactureService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/factures")
@AllArgsConstructor
public class FactureController {
    private final FactureService factureService;

    @PostMapping("/create")
    public Facture create(@RequestBody Facture facture) {
        return factureService.calcul(facture);
    }

    @GetMapping("/readAll")
    public List<Facture> readAll() {
        return factureService.readAll();
    }

    @GetMapping("/readByNumFacture/{numeroFacture}")
    public Facture readFacture(@PathVariable String numeroFacture) {
        return factureService.findFacture(numeroFacture);
    }
}
