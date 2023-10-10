package com.toure.hayib.HealthCareCovid.repository;

import com.toure.hayib.HealthCareCovid.model.HealthCare;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HealthCareRepository extends CrudRepository<HealthCare, Long> {
}
