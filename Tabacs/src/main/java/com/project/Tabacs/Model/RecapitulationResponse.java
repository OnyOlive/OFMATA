package com.project.Tabacs.Model;

import jakarta.persistence.Entity;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class RecapitulationResponse {
    private List<RecapitulationLC> recapitulationLCList;
    private Integer sommeNB;
    private Double sommePB;
    private Double sommePN;
    private Double sommeMontant;

    public void addRecap(List<RecapitulationLC> recap){
        if(recapitulationLCList == null) {
            recapitulationLCList = new ArrayList<>();
        }
        for (RecapitulationLC r: recap) {
            recapitulationLCList.add(r);
        }
    }
}
