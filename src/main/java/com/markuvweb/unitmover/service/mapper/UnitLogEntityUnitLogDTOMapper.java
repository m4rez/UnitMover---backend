package com.markuvweb.unitmover.service.mapper;

import org.mapstruct.Mapper;
import com.markuvweb.unitmover.model.dto.UnitLogDTO;
import com.markuvweb.unitmover.model.entity.UnitLogEntity;

@Mapper(componentModel = "spring")
public interface UnitLogEntityUnitLogDTOMapper {
    UnitLogDTO UnitLogEntityUnitLogDTO (UnitLogEntity unitLogEntity);
    UnitLogEntity UnitLogDTOUnitLogEntity (UnitLogDTO unitLogDTO);
}
