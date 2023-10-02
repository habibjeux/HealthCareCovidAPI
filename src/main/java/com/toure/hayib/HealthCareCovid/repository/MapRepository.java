package com.toure.hayib.HealthCareCovid.repository;

import com.toure.hayib.HealthCareCovid.model.Map;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapRepository extends CrudRepository<Map, Long> {
}
