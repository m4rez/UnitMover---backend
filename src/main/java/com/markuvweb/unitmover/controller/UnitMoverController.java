package com.markuvweb.unitmover.controller;

import com.markuvweb.unitmover.model.SnoStationMerge;
import com.markuvweb.unitmover.model.dto.SnoDTO;
import com.markuvweb.unitmover.service.StringExtractor;
import com.markuvweb.unitmover.service.TimeService;
import com.markuvweb.unitmover.service.entity.Interface.SnoInterface;
import com.markuvweb.unitmover.service.entity.Interface.StationsInterface;
import com.markuvweb.unitmover.service.entity.Interface.UnitLogInterface;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


@RestController
@RequestMapping("/projekty/unitmover/")
@CrossOrigin(origins = {"http://localhost:8084","https://markuvtest.website","https://portfolio-zezula.website"}, methods = {RequestMethod.GET, RequestMethod.POST}, allowCredentials = "true") //
public class UnitMoverController {
    @Autowired
    UnitLogInterface unitLogInterface;
    @Autowired
    SnoInterface snoInterface;
    @Autowired
    StationsInterface stationsInterface;
    @Autowired
    TimeService timeService;
    @Autowired
    StringExtractor stringExtractor;


    @GetMapping("getunits")
    public ResponseEntity<ArrayList<SnoStationMerge>> renderUnits(@RequestParam("sno") String sno) {
        //display
        System.out.println("get units zavolana");
        String []splitSno = stringExtractor.extractSno(sno);
        ArrayList<SnoStationMerge> snoStationMergeArrayList = new ArrayList<>();
        snoStationMergeArrayList = snoInterface.showSnos(splitSno, snoStationMergeArrayList);
    return new ResponseEntity<>(snoStationMergeArrayList, HttpStatus.CREATED);
    }
    @PostMapping("moveunit")
    public ResponseEntity<SnoStationMerge> moveUnit(@RequestBody SnoStationMerge sno) {
            //move
            ArrayList<String> allowedStations = stationsInterface.getAllowedStations(sno.getSnoDTO().getModel());
            if (allowedStations.contains(sno.getSnoDTO().getWc())) {
                //set DTO
                sno.getSnoDTO().setNextWc(snoInterface.nextStation(allowedStations, sno.getSnoDTO().getWc()));
                sno.getSnoDTO().setUdt(timeService.getTime());
                System.out.println(sno.getSnoDTO().getUdt());
                snoInterface.saveSno(sno.getSnoDTO());
                //insert logs
                unitLogInterface.logsInserter(unitLogInterface.findUnitLogs(sno.getSnoDTO().getSno()), sno.getSnoDTO().getWc(), sno.getSnoDTO().getSno(), allowedStations);
            }
            //display
    return new ResponseEntity<>(sno, HttpStatus.CREATED);
    }
    @PostMapping("moveunits")
    public ResponseEntity<ArrayList<SnoStationMerge>> moveUnits(@RequestBody ArrayList<SnoStationMerge> snoStationMergeArrayList) {
        //move
        for (SnoStationMerge snoStationMerge : snoStationMergeArrayList) {
            SnoDTO snoDTO = snoStationMerge.getSnoDTO();
            ArrayList<String> allowedStations = stationsInterface.getAllowedStations(snoDTO.getModel());
            if (allowedStations.contains(snoDTO.getWc())) {
                //set DTO
                snoDTO.setWc(allowedStations.get(allowedStations.size() - 2));
                snoDTO.setNextWc(allowedStations.get(allowedStations.size() - 1));
                snoDTO.setUdt(timeService.getTime());
                System.out.println(snoDTO.getUdt());
                snoInterface.saveSno(snoDTO);
                //insert logs
                unitLogInterface.logsInserter(unitLogInterface.findUnitLogs(snoDTO.getSno()), snoDTO.getWc(), snoDTO.getSno(), allowedStations);
            }
        }
    return new ResponseEntity<>(snoStationMergeArrayList, HttpStatus.CREATED);
    }
}
