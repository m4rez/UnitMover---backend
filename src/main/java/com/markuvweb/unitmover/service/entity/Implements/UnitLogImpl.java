package com.markuvweb.unitmover.service.entity.Implements;

import com.markuvweb.unitmover.data.repository.UnitLogRepository;
import com.markuvweb.unitmover.model.dto.UnitLogDTO;
import com.markuvweb.unitmover.model.entity.UnitLogEntity;
import com.markuvweb.unitmover.service.TimeService;
import com.markuvweb.unitmover.service.entity.Interface.UnitLogInterface;
import com.markuvweb.unitmover.service.mapper.UnitLogEntityUnitLogDTOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UnitLogImpl implements UnitLogInterface {
    @Autowired
    TimeService timeService;
    @Autowired
    UnitLogRepository unitLogRepository;
    @Autowired
    SnoImpl snoImpl;
    @Autowired
    UnitLogEntityUnitLogDTOMapper unitLogEntityUnitLogDTOMapper;
    private UnitLogDTO findById(Long Id){
        return unitLogEntityUnitLogDTOMapper.UnitLogEntityUnitLogDTO(unitLogRepository.findById(Id).orElseThrow());
    }
    private void saveLog(String sno, String station, String Cdt){
        UnitLogDTO unitLogDTO = new UnitLogDTO();
        unitLogDTO.setUnitDTO(snoImpl.loadBySno(sno).getId(),sno,"FIS",station,1,"Manual","220031",Cdt,Cdt);
        unitLogRepository.save(unitLogEntityUnitLogDTOMapper.UnitLogDTOUnitLogEntity(unitLogDTO));
    }
    private void removeLog (Long Id){
        UnitLogDTO unitLogDTO = findById(Id);
        unitLogDTO.setIsPass(2);
        unitLogRepository.save(unitLogEntityUnitLogDTOMapper.UnitLogDTOUnitLogEntity(unitLogDTO));
    }
    private void logRemover(ArrayList<UnitLogDTO> validLogs, String station, ArrayList<String> allowedStations) {
        for(UnitLogDTO validLog :validLogs) {
            if(allowedStations.indexOf(validLog.getWc())>allowedStations.indexOf(station) ){
                removeLog(validLog.getId());
            }
        }
    }
    private void logInserter(ArrayList<UnitLogDTO> validLogs, String allowedStation, String sno, int minutes) {
        boolean logExist = false;
        for (UnitLogDTO validLog : validLogs) {
            if (validLog.getWc().equals(allowedStation)) {
                logExist = true;
            }
        }
        if(!logExist){
            saveLog(sno, allowedStation, timeService.getTime(minutes));
        }
    }
    public void logsInserter(ArrayList<UnitLogDTO> unitLogs, String station, String sno, ArrayList<String> allowedStations){
        ArrayList<UnitLogDTO> validLogs = logValidator(unitLogs);
        int minutes = 0;
        for(String allowedStation :allowedStations) {
            if(allowedStations.indexOf(allowedStation)<allowedStations.indexOf(station)||allowedStations.indexOf(allowedStation)==allowedStations.indexOf(station)) {
                logInserter(validLogs, allowedStation, sno, minutes);
                logRemover(validLogs, station, allowedStations);
                minutes = minutes + 5;
            }
        }
    }

    public ArrayList<UnitLogDTO> logValidator(ArrayList<UnitLogDTO> unitLogs){
        ArrayList<UnitLogDTO> validLogs = new ArrayList<>();
        for (UnitLogDTO unitLog : unitLogs) {
            if (unitLog.getIsPass() == 1) {
                validLogs.add(unitLog);
            }
        }
        return validLogs;
    }
    public ArrayList<UnitLogDTO> findUnitLogs (String sno){
        ArrayList<UnitLogEntity> unitLogEntities = unitLogRepository.findAllBySno(sno);
        ArrayList<UnitLogDTO> unitLogDTOs = new ArrayList<>();
        for (UnitLogEntity unitLogEntity : unitLogEntities){
            unitLogDTOs.add(unitLogEntityUnitLogDTOMapper.UnitLogEntityUnitLogDTO(unitLogEntity));
        }
        return unitLogDTOs;
    }
}

