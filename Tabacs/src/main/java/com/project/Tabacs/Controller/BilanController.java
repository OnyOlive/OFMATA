package com.project.Tabacs.Controller;

import com.project.Tabacs.Service.BilanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Year;

@RestController
@RequestMapping("/bilans")
@AllArgsConstructor
public class BilanController {
    private  final BilanService bilanService;

    @GetMapping("/getPoids/{annee}")
    public Double getPoidsTotalAnnuel (@PathVariable Year annee) {
        return bilanService.getPoidsTotalAnnuel(annee);
    }
}
