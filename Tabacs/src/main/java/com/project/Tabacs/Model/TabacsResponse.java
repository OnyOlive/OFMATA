package com.project.Tabacs.Model;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class TabacsResponse {
    private List<Tabacs> tabacs = new ArrayList<>();
    private Double poidsTotalParGrade;
    private Double poidsTotalParVariete;
    private Double poidsTotalParRecolte;
    private Double poidsTotalParMagasin;

    public void addTabacs(List<Tabacs> tabacsArg){
        if(tabacs == null) {
            tabacs = new ArrayList<>();
        }
        for (Tabacs tabac: tabacsArg) {
            tabacs.add(tabac);
        }
    }
}
