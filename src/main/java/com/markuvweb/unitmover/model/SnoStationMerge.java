package com.markuvweb.unitmover.model;

import com.markuvweb.unitmover.model.dto.SnoDTO;

import java.util.ArrayList;

public class SnoStationMerge {

    private SnoDTO snoDTO;
    private ArrayList<String> stationsArray;
    public SnoStationMerge(SnoDTO snoDTO, ArrayList<String> stationsArray){
        this.setSnoDTO(snoDTO);
        this.setStationsArray(stationsArray);
    }

    public SnoDTO getSnoDTO() {
        return snoDTO;
    }

    public void setSnoDTO(SnoDTO snoDTO) {
        this.snoDTO = snoDTO;
    }


    public ArrayList<String> getStationsArray() {
        return stationsArray;
    }

    public void setStationsArray(ArrayList<String> stationsArray) {
        this.stationsArray = stationsArray;
    }
}
