package com.project.Tabacs.Controller;

import com.project.Tabacs.Model.Zone;
import com.project.Tabacs.Service.ZoneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/zones")
@AllArgsConstructor
public class ZoneController {
    private final ZoneService zoneService;

    @GetMapping("/read")
    public List<Zone> read(){
        return zoneService.lire();
    }

    @PostMapping("/create")
    public Zone create(@RequestBody Zone zone){
        return zoneService.ajouterZone(zone);
    }

    @PutMapping("/update/{idZone}")
    public Zone update(@PathVariable Integer idZone, @RequestBody Zone zone){
        return  zoneService.modifierZone(idZone, zone);
    }

    @DeleteMapping("/delete/{idZone}")
    public String delete(@PathVariable Integer idZone){
        return zoneService.supprimerZone(idZone);
    }

    @GetMapping("/readByZone/{nomZone}")
    public List<Zone> findZone(@PathVariable String nomZone){
        return zoneService.rechercherZone(nomZone);
    }

    @GetMapping("/readByID/{idZone}")
    public Zone findByID(@PathVariable Integer idZone) {
        return zoneService.rechercheParID(idZone);
    }
}
