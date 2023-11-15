package com.project.Tabacs.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import com.project.Tabacs.Model.Magasins;
import com.project.Tabacs.Service.MagasinsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/magasins")
@AllArgsConstructor
@CrossOrigin(origins = "http://localhost:5173")
public class MagasinsController {
     private final MagasinsService magasinsService;

     @PostMapping("/create")
     public Magasins create(@RequestBody Magasins magasins){
         return magasinsService.creerMagasins(magasins);
     }

     @GetMapping("/read")
     public List<Magasins> read() {
          return magasinsService.lire();
     }

     @GetMapping("/readByID/{idMagasin}")
     public Magasins findByID(@PathVariable Integer idMagasin) {
          return magasinsService.findByID(idMagasin);
     }

     @GetMapping("/match/{nomMagasin}/{nomSecteur}")
     public Magasins find(@PathVariable String nomMagasin, @PathVariable String nomSecteur){
          return magasinsService.find(nomMagasin, nomSecteur);
     }

     @GetMapping("/readByMagasin/{nomMagasin}")
     public List<Magasins> findByNomMagasin(@PathVariable String nomMagasin){
          return magasinsService.rechercherMagasin(nomMagasin);
     }

     @GetMapping("/readBySecteur/{nomSecteur}")
     public List<Magasins> findBySecteur(@PathVariable String nomSecteur) {
          return magasinsService.rechercherSecteur(nomSecteur);
     }

     @GetMapping("/readByZone/{nomZone}")
     public List<Magasins> findByZone(@PathVariable String nomZone) {
          return magasinsService.rechercherZone(nomZone);
     }

     @PutMapping("/update/{idMagasin}")
     public Magasins update(@PathVariable Integer idMagasin, @RequestBody Magasins magasins) {
          return magasinsService.modifierMagasins(idMagasin, magasins);
     }

     @DeleteMapping("/delete/{idMagasin}")
     public String delete(@PathVariable Integer idMagasin) {
          return magasinsService.supprimerMagasins(idMagasin);
     }


}
