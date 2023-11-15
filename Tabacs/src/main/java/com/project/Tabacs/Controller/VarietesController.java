package com.project.Tabacs.Controller;

import com.project.Tabacs.Model.Varietes;
import com.project.Tabacs.Service.VarietesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/varietes")
@AllArgsConstructor
public class VarietesController {
    private final VarietesService varietesService;

    @PostMapping("/create")
    public Varietes create(@RequestBody Varietes varietes) {
        return varietesService.creerVariete(varietes);
    }

    @GetMapping("/read")
    public List<Varietes> read() {
        return varietesService.lire();
    }

    @GetMapping("/readByID/{idVariete}")
    public Varietes findByID(@PathVariable Integer idVariete){
        return varietesService.findByID(idVariete);
    }

    @GetMapping("/readByNomVariete/{nomVariete}")
    public List<Varietes> findVariete(@PathVariable String nomVariete) {
        return  varietesService.findVariete(nomVariete);
    }

    @PutMapping("/update/{idVariete}")
    public Varietes update(@PathVariable Integer idVariete, @RequestBody Varietes varietes) {
        return varietesService.modifierVariete(idVariete, varietes);
    }

    @DeleteMapping("delete/{idVariete}")
    public String delete(@PathVariable Integer idVariete) {
        return varietesService.supprimerVariete(idVariete);
    }
}
