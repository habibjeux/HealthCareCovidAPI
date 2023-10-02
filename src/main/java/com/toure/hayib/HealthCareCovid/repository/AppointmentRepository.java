package com.toure.hayib.HealthCareCovid.repository;

import com.toure.hayib.HealthCareCovid.model.Appointment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
}
