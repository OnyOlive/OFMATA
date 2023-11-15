package com.project.Tabacs.Controller;

import com.project.Tabacs.Model.Autorisation;
import com.project.Tabacs.Service.AutorisationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autorisation")
@AllArgsConstructor
public class AutorisationController {
    private final AutorisationService autorisationService;

    @GetMapping("/readAll")
    public List<Autorisation> read() {
        return autorisationService.lire();
    }

    @PostMapping("/create")
    public Autorisation create(@RequestBody Autorisation autorisation){
        return autorisationService.creerAE(autorisation);
    }

    @GetMapping("/readByNumeroAE/{numeroAE}")
    public Autorisation readByNumAE(@PathVariable String numeroAE) {
        return autorisationService.rechercherParID(numeroAE);
    }
}
