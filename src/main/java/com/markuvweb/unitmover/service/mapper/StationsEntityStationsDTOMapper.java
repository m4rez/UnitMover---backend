package com.markuvweb.unitmover.service.mapper;

import org.mapstruct.Mapper;
import com.markuvweb.unitmover.model.dto.StationsDTO;
import com.markuvweb.unitmover.model.entity.StationsEntity;

@Mapper(componentModel = "spring")
public interface StationsEntityStationsDTOMapper {
    StationsDTO stationsEntityToStationsDTO (StationsEntity stationsEntity);
    StationsEntity stationsDTOToStationsEntity (StationsDTO stationsDTO);
}
