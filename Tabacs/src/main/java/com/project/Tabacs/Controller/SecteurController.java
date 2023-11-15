package com.project.Tabacs.Controller;

import com.project.Tabacs.Model.Secteur;
import com.project.Tabacs.Service.SecteurService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/secteurs")
@AllArgsConstructor
public class SecteurController {
    private final SecteurService secteurService;

    @GetMapping("/read")
    public List<Secteur> read() {
        return secteurService.lire();
    }

    @PostMapping("/create")
    public  Secteur create(@RequestBody Secteur secteur) {
        return secteurService.ajouterSecteur(secteur);
    }

    @PutMapping("/update/{idSecteur}")
    public Secteur update(@PathVariable Integer idSecteur, @RequestBody Secteur secteur){
        return secteurService.modifierSecteur(idSecteur, secteur);
    }

    @DeleteMapping("/delete/{idSecteur}")
    public String delete(@PathVariable Integer idSecteur){
        return secteurService.supprimerSecteur(idSecteur);
    }

    @GetMapping("/readBySecteur/{nomSecteur}")
    public List<Secteur> findBySecteur(@PathVariable String nomSecteur){
        return secteurService.rechercherParSecteur(nomSecteur);
    }

    @GetMapping("/readByID/{idSecteur}")
    public Secteur findByID(@PathVariable Integer idSecteur){
        return secteurService.findByID(idSecteur);
    }

    @GetMapping("/readByZone/{nomZone}")
    public List<Secteur> findByZone(@PathVariable String nomZone){
        return secteurService.rechercherParZone(nomZone);
    }
}
