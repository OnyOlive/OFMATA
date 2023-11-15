package com.project.Tabacs.Controller;

import com.project.Tabacs.Model.Tabacs;
//import com.project.Tabacs.Model.TabacsResponse;
import com.project.Tabacs.Service.TabacsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

//import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/tabacs")
@AllArgsConstructor
public class TabacsController {
    private final TabacsService tabacsService;

    /*@PostMapping("/create")
    public Tabacs create(@RequestBody Tabacs tabacs) {
        System.out.println(tabacs.toString());
        return tabacsService.deposerTabacs(tabacs);
    }*/

    @GetMapping("/read")
    public List<Tabacs> read(){
        return tabacsService.lire();
    }

    /*@GetMapping("/readByVariete/{nomVariete}")
    public TabacsResponse findByVariete(@PathVariable String nomVariete) {
        TabacsResponse tabacsResponse = TabacsResponse.builder()
                .poidsTotalParVariete(tabacsService.sommePoidsParVariete(nomVariete))
                .build();
        tabacsResponse.addTabacs(tabacsService.rechercherParVariete(nomVariete));
        return tabacsResponse;
    }

    @GetMapping("readByGrade/{nomGrade}")
    public TabacsResponse findByGrade(@PathVariable String nomGrade){
        TabacsResponse tabacsResponse = TabacsResponse.builder()
                .poidsTotalParGrade(tabacsService.sommePoidsParGrade(nomGrade))
                .build();
        tabacsResponse.addTabacs(tabacsService.rechercherParGrade(nomGrade));
        return tabacsResponse;
    }

    @GetMapping("/readByRecolte/{recolte}")
    public TabacsResponse findByRecolte(@PathVariable Integer recolte){
        TabacsResponse tabacsResponse = TabacsResponse.builder()
                .poidsTotalParRecolte(tabacsService.sommePoidsParRecolte(recolte))
                .build();
        tabacsResponse.addTabacs(tabacsService.rechercherParRecolte(recolte));
        return tabacsResponse;
    }

    @GetMapping("/readByDate/{dateDepot}")
    public List<Tabacs> findByDate(@PathVariable LocalDate dateDepot){
        return tabacsService.rechercherParDate(dateDepot);
    }

    @GetMapping("readByMagasin/{nomMagasin}")
    public TabacsResponse findByMagasin(@PathVariable String nomMagasin) {
        TabacsResponse tabacsResponse = TabacsResponse.builder()
                .poidsTotalParMagasin(tabacsService.sommePoidsParMagasin(nomMagasin))
                .build();
        tabacsResponse.addTabacs(tabacsService.rechercherParMagasin(nomMagasin));
        return tabacsResponse;
    }*/
}



