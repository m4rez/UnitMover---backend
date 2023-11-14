package com.markuvweb.unitmover.service.mapper;

import com.markuvweb.unitmover.model.dto.UnitLogDTO;
import com.markuvweb.unitmover.model.entity.UnitLogEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-10T12:40:58+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Eclipse Adoptium)"
)
@Component
public class UnitLogEntityUnitLogDTOMapperImpl implements UnitLogEntityUnitLogDTOMapper {

    @Override
    public UnitLogDTO UnitLogEntityUnitLogDTO(UnitLogEntity unitLogEntity) {
        if ( unitLogEntity == null ) {
            return null;
        }

        UnitLogDTO unitLogDTO = new UnitLogDTO();

        unitLogDTO.setSnoId( unitLogEntity.getSnoId() );
        unitLogDTO.setSno( unitLogEntity.getSno() );
        unitLogDTO.setPdLine( unitLogEntity.getPdLine() );
        unitLogDTO.setWc( unitLogEntity.getWc() );
        unitLogDTO.setIsPass( unitLogEntity.getIsPass() );
        unitLogDTO.setInputType( unitLogEntity.getInputType() );
        unitLogDTO.setEditor( unitLogEntity.getEditor() );
        unitLogDTO.setCdt( unitLogEntity.getCdt() );
        unitLogDTO.setUdt( unitLogEntity.getUdt() );
        unitLogDTO.setId( unitLogEntity.getId() );

        return unitLogDTO;
    }

    @Override
    public UnitLogEntity UnitLogDTOUnitLogEntity(UnitLogDTO unitLogDTO) {
        if ( unitLogDTO == null ) {
            return null;
        }

        UnitLogEntity unitLogEntity = new UnitLogEntity();

        unitLogEntity.setId( unitLogDTO.getId() );
        unitLogEntity.setSnoId( unitLogDTO.getSnoId() );
        unitLogEntity.setSno( unitLogDTO.getSno() );
        unitLogEntity.setPdLine( unitLogDTO.getPdLine() );
        unitLogEntity.setWc( unitLogDTO.getWc() );
        unitLogEntity.setIsPass( unitLogDTO.getIsPass() );
        unitLogEntity.setInputType( unitLogDTO.getInputType() );
        unitLogEntity.setEditor( unitLogDTO.getEditor() );
        unitLogEntity.setCdt( unitLogDTO.getCdt() );
        unitLogEntity.setUdt( unitLogDTO.getUdt() );

        return unitLogEntity;
    }
}
