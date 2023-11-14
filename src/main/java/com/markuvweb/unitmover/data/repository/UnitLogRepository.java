package com.markuvweb.unitmover.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.markuvweb.unitmover.model.entity.UnitLogEntity;

import java.util.ArrayList;

public interface UnitLogRepository extends CrudRepository<UnitLogEntity, Long> {
    ArrayList<UnitLogEntity> findAllBySno(String sno);
}
