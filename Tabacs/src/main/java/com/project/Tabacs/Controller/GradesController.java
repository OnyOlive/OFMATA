package com.project.Tabacs.Controller;

import com.project.Tabacs.Model.Grades;
import com.project.Tabacs.Service.GradesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/grades")
@AllArgsConstructor
public class GradesController {
    private final GradesService gradesService;

    @PostMapping("/create")
    public Grades create(@RequestBody Grades grades) {
        return gradesService.creerGrade(grades);
    }

    @GetMapping("/read")
    public List<Grades> read() {
        return gradesService.lire();
    }

    @GetMapping("/readByGrade/{nomGrade}")
    public List<Grades> findGrade(@PathVariable String nomGrade) {
        return gradesService.rechercheGrade(nomGrade);
    }

    @GetMapping("/readByID/{idGrade}")
    public Grades rechercherParID(@PathVariable Integer idGrade) {
        return gradesService.rechercherParID(idGrade);
    }

    @GetMapping("readByVariete/{nomVariete}")
    public List<Grades> rechercherParVariete(@PathVariable String nomVariete) {
        return gradesService.rechercheParVariete(nomVariete);
    }

    @PutMapping("/update/{idGrade}")
    public Grades update(@PathVariable Integer idGrade, @RequestBody Grades grades) {
        return gradesService.modifierGrade(idGrade, grades);
    }

    @DeleteMapping("/delete/{idGrade}")
    public String delete(@PathVariable Integer idGrade) {
        return gradesService.supprimerGrade(idGrade);
    }
}
