package com.markuvweb.unitmover.service.entity.Interface;

import com.markuvweb.unitmover.model.dto.UnitLogDTO;

import java.util.ArrayList;

public interface UnitLogInterface {
    void logsInserter(ArrayList<UnitLogDTO> unitLogs, String station, String sno, ArrayList<String> allowedStations);
    ArrayList<UnitLogDTO> logValidator(ArrayList<UnitLogDTO> unitLogs);
    ArrayList<UnitLogDTO> findUnitLogs (String sno);
}
