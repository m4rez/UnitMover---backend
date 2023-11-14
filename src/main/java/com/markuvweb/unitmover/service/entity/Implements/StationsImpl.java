package com.markuvweb.unitmover.service.entity.Implements;

import com.markuvweb.unitmover.data.repository.StationsRepository;
import com.markuvweb.unitmover.model.dto.StationsDTO;
import com.markuvweb.unitmover.service.entity.Interface.StationsInterface;
import com.markuvweb.unitmover.service.mapper.StationsEntityStationsDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Arrays;

@Service
public class StationsImpl implements StationsInterface {

    @Autowired
    StationsEntityStationsDTOMapper stationsEntityStationsDTOMapper;
    @Autowired
    StationsRepository stationsRepository;

    private StationsDTO loadByModel (String unitModel){
        return stationsEntityStationsDTOMapper.stationsEntityToStationsDTO(stationsRepository.findByModel(unitModel).orElseThrow());
    }
    public ArrayList<String> getAllowedStations(String unitModel){
        String[] stationsSplit = loadByModel(unitModel).getFlow().split("/");
        ArrayList<String> stationsArray= new ArrayList<>(Arrays.asList(stationsSplit));
        ArrayList<String> allowedStations = new ArrayList<>();
        for(String fetchedStation : stationsArray){
            if (stationsArray.indexOf(fetchedStation)>=stationsArray.indexOf("49") && stationsArray.indexOf(fetchedStation)<=stationsArray.indexOf("74")) {
                allowedStations.add(fetchedStation);
            }
        }
        return allowedStations;
    }
}
