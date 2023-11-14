package com.markuvweb.unitmover.service.entity.Interface;

import com.markuvweb.unitmover.model.SnoStationMerge;
import com.markuvweb.unitmover.model.dto.SnoDTO;

import java.util.ArrayList;
import java.util.List;

public interface SnoInterface {
     SnoDTO loadBySno(String sno);
     String nextStation(List<String> stationsArray, String station);
     void saveSno(SnoDTO snoDTO);
     ArrayList<SnoStationMerge> showSnos(String[] splitSno, ArrayList<SnoStationMerge> snoStationMergeArrayList);
}
