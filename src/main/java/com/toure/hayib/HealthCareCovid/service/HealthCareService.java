package com.toure.hayib.HealthCareCovid.service;

import com.toure.hayib.HealthCareCovid.model.HealthCare;
import com.toure.hayib.HealthCareCovid.repository.HealthCareRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HealthCareService {

    @Autowired
    private HealthCareRepository healthCareRepository;

    public HealthCare createHealthCare(HealthCare healthCare) {
        return healthCareRepository.save(healthCare);
    }

    public List<HealthCare> getAllHealthCare() {
        List<HealthCare> healthCares = new ArrayList<>();
        healthCareRepository.findAll().forEach(healthCares::add);
        return healthCares;
    }

    public Optional<HealthCare> getHealthCareByID(Long id) {
        return healthCareRepository.findById(id);
    }

    public HealthCare updateHealthCare(Long id, HealthCare newHealthCare) {
        Optional<HealthCare> healthCare = healthCareRepository.findById(id);
        if(healthCare.isPresent()) {
            HealthCare existingHealthCare = healthCare.get();
            existingHealthCare.setAddress(newHealthCare.getAddress());
            existingHealthCare.setEmail(newHealthCare.getEmail());
            existingHealthCare.setMap(newHealthCare.getMap());
            existingHealthCare.setName(newHealthCare.getName());
            existingHealthCare.setPhone(newHealthCare.getPhone());
            existingHealthCare.setTestAvailability(newHealthCare.getTestAvailability());
            existingHealthCare.setType(newHealthCare.getType());
            existingHealthCare.setVaccineAvailability(newHealthCare.getVaccineAvailability());
            healthCareRepository.save(existingHealthCare);
            return existingHealthCare;
        }
        return null;
    }

    public void deleteAllHeathCare() {
        healthCareRepository.deleteAll();
    }
    public void deleteHealthCareByID(Long id) {
        healthCareRepository.deleteById(id);
    }

}
