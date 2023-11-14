package com.markuvweb.unitmover.data.repository;

import org.springframework.data.repository.CrudRepository;
import com.markuvweb.unitmover.model.entity.StationsEntity;

import java.util.Optional;

public interface StationsRepository extends CrudRepository<StationsEntity, Long> {
    Optional<StationsEntity> findByModel(String Model);

}
