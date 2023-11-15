package com.project.Tabacs.Controller;

import com.project.Tabacs.Model.SocieteClients;
import com.project.Tabacs.Service.SocietesClientsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/societes")
@AllArgsConstructor
public class SocietesClientsController {
    private final SocietesClientsService societesClientsService;

    @PostMapping("/create")
    public SocieteClients create(@RequestBody SocieteClients societeClients) {
        return societesClientsService.creerClient(societeClients);
    }

    @GetMapping("/read")
    public List<SocieteClients> read() {
        return societesClientsService.lire();
    }

    @GetMapping("/readByID/{idSociete}")
    public SocieteClients findByID(@PathVariable Integer idSociete) {
        return societesClientsService.rechercherParID(idSociete);
    }

    @GetMapping("/readByNomSociete/{nomSociete}")
    public List<SocieteClients> findSociete(@PathVariable String nomSociete) {
        return societesClientsService.rechercherParSociete(nomSociete);
    }

    @PutMapping("/update/{idSociete}")
    public SocieteClients update(@PathVariable Integer idSociete, @RequestBody SocieteClients societeClients) {
        return societesClientsService.modifierClient(idSociete, societeClients);
    }

    @DeleteMapping("/delete/{idSociete}")
    public String delete(@PathVariable Integer idSociete) {
        return societesClientsService.supprimerClient(idSociete);
    }
}
