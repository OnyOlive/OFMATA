package com.project.Tabacs.Service;

import com.project.Tabacs.Model.Tabacs;

import java.time.LocalDate;
import java.util.List;

public interface TabacsService {
    //Tabacs deposerTabacs(Tabacs tabacs);
    List<Tabacs> lire();


    /*List<Tabacs> rechercherParRecolte(Integer recolte);
    List<Tabacs>  rechercherParDate(LocalDate dateDepot);
    List<Tabacs> rechercherParGrade(String nomGrade);
    List<Tabacs> rechercherParVariete(String nomVariete);
    List<Tabacs> rechercherParMagasin(String nomMagasin);
    Double sommePoidsParGrade(String nomGrade);
    Double sommePoidsParRecolte(Integer recolte);
    Double sommePoidsParVariete(String nomVariete);
    Double sommePoidsParMagasin(String nomMagasin);*/
}
