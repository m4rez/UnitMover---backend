package com.markuvweb.unitmover.service.mapper;

import com.markuvweb.unitmover.model.dto.StationsDTO;
import com.markuvweb.unitmover.model.entity.StationsEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-10T12:40:58+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Eclipse Adoptium)"
)
@Component
public class StationsEntityStationsDTOMapperImpl implements StationsEntityStationsDTOMapper {

    @Override
    public StationsDTO stationsEntityToStationsDTO(StationsEntity stationsEntity) {
        if ( stationsEntity == null ) {
            return null;
        }

        StationsDTO stationsDTO = new StationsDTO();

        stationsDTO.setModel( stationsEntity.getModel() );
        stationsDTO.setFtype( stationsEntity.getFtype() );
        stationsDTO.setFlow( stationsEntity.getFlow() );
        stationsDTO.setEditor( stationsEntity.getEditor() );
        stationsDTO.setCdt( stationsEntity.getCdt() );
        stationsDTO.setUdt( stationsEntity.getUdt() );

        return stationsDTO;
    }

    @Override
    public StationsEntity stationsDTOToStationsEntity(StationsDTO stationsDTO) {
        if ( stationsDTO == null ) {
            return null;
        }

        StationsEntity stationsEntity = new StationsEntity();

        stationsEntity.setModel( stationsDTO.getModel() );
        stationsEntity.setFtype( stationsDTO.getFtype() );
        stationsEntity.setFlow( stationsDTO.getFlow() );
        stationsEntity.setEditor( stationsDTO.getEditor() );
        stationsEntity.setCdt( stationsDTO.getCdt() );
        stationsEntity.setUdt( stationsDTO.getUdt() );

        return stationsEntity;
    }
}
