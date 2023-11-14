package com.markuvweb.unitmover.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.markuvweb.unitmover.model.entity.SnoEntity;


import java.util.Optional;

public interface SnoRepository extends CrudRepository<SnoEntity, Long> {

    Optional<SnoEntity> findBySnoIgnoreCase(String SNO);
}
