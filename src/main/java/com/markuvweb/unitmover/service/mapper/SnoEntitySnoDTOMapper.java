package com.markuvweb.unitmover.service.mapper;

import org.mapstruct.Mapper;
import com.markuvweb.unitmover.model.dto.SnoDTO;
import com.markuvweb.unitmover.model.entity.SnoEntity;

@Mapper(componentModel = "spring")
public interface SnoEntitySnoDTOMapper {
    SnoDTO entityToDTO (SnoEntity snoEntity);
    SnoEntity DTOToEntity (SnoDTO snoDTO);
}
