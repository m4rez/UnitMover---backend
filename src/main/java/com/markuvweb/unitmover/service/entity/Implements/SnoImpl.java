package com.markuvweb.unitmover.service.entity.Implements;

import com.markuvweb.unitmover.data.repository.SnoRepository;
import com.markuvweb.unitmover.model.dto.SnoDTO;
import com.markuvweb.unitmover.service.entity.Interface.SnoInterface;
import com.markuvweb.unitmover.service.mapper.SnoEntitySnoDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.markuvweb.unitmover.model.SnoStationMerge;

import java.util.ArrayList;
import java.util.List;

@Service
public class SnoImpl implements SnoInterface {
    @Autowired
    SnoRepository snoRepository;
    @Autowired
    StationsImpl stationsImpl;
    @Autowired
    SnoEntitySnoDTOMapper snoEntitySnoDTOMapper;

    public SnoDTO loadBySno(String sno){
        return snoEntitySnoDTOMapper.entityToDTO(snoRepository.findBySnoIgnoreCase(sno).orElseThrow());
    }
    public void saveSno(SnoDTO snoDTO){
        snoRepository.save(snoEntitySnoDTOMapper.DTOToEntity(snoDTO));
    }

    public String nextStation(List<String> stationsArray,String station){
        String nextStation = "";

        for( String iteratedStation : stationsArray){
            if(iteratedStation.equals(station)){
                nextStation = stationsArray.get(stationsArray.indexOf(iteratedStation)+1);
            }
        }
        return  nextStation;
    }

    public ArrayList<SnoStationMerge> showSnos(String[] splitSno,ArrayList<SnoStationMerge> snoStationMergeArrayList) {
        for (String sno : splitSno) {

            SnoDTO snoDTO = loadBySno(sno);

            snoDTO.setCdt(snoDTO.getCdt().substring(0, 19));
            snoDTO.setUdt(snoDTO.getUdt().substring(0, 19));
            ArrayList<String> allowedStations = stationsImpl.getAllowedStations(snoDTO.getModel());
            allowedStations.remove(allowedStations.size() - 1);
            snoStationMergeArrayList.add(new SnoStationMerge(snoDTO, allowedStations));
        }
        return snoStationMergeArrayList;
    }

}
