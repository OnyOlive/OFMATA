package com.project.Tabacs.Controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TabacsDansColisage {
    private Integer recolte;
    private String secteur;
    private String magasin;
    private String variete;
}
