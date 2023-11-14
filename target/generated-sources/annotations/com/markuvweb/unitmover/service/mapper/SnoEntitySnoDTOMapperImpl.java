package com.markuvweb.unitmover.service.mapper;

import com.markuvweb.unitmover.model.dto.SnoDTO;
import com.markuvweb.unitmover.model.entity.SnoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-10T12:40:57+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.1 (Eclipse Adoptium)"
)
@Component
public class SnoEntitySnoDTOMapperImpl implements SnoEntitySnoDTOMapper {

    @Override
    public SnoDTO entityToDTO(SnoEntity snoEntity) {
        if ( snoEntity == null ) {
            return null;
        }

        SnoDTO snoDTO = new SnoDTO();

        snoDTO.setId( snoEntity.getId() );
        snoDTO.setSno( snoEntity.getSno() );
        snoDTO.setModel( snoEntity.getModel() );
        snoDTO.setWc( snoEntity.getWc() );
        snoDTO.setNextWc( snoEntity.getNextWc() );
        snoDTO.setCdt( snoEntity.getCdt() );
        snoDTO.setUdt( snoEntity.getUdt() );

        return snoDTO;
    }

    @Override
    public SnoEntity DTOToEntity(SnoDTO snoDTO) {
        if ( snoDTO == null ) {
            return null;
        }

        SnoEntity snoEntity = new SnoEntity();

        snoEntity.setId( snoDTO.getId() );
        snoEntity.setSno( snoDTO.getSno() );
        snoEntity.setModel( snoDTO.getModel() );
        snoEntity.setWc( snoDTO.getWc() );
        snoEntity.setNextWc( snoDTO.getNextWc() );
        snoEntity.setCdt( snoDTO.getCdt() );
        snoEntity.setUdt( snoDTO.getUdt() );

        return snoEntity;
    }
}
