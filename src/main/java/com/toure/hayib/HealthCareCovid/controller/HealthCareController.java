package com.toure.hayib.HealthCareCovid.controller;

import com.toure.hayib.HealthCareCovid.model.HealthCare;
import com.toure.hayib.HealthCareCovid.service.HealthCareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class HealthCareController {
    @Autowired
    private HealthCareService healthCareService;

    @PostMapping("/healthcare")
    public HealthCare createHealthCare(@RequestBody HealthCare healthCare) {
        return  healthCareService.createHealthCare(healthCare);
    }

    @GetMapping("healthcares")
    public List<HealthCare> getAllHealthCare() {
        return healthCareService.getAllHealthCare();
    }

    @GetMapping("healthcare/{id}")
    public Optional<HealthCare> getHealthCareByID(@PathVariable Long id) {
        return healthCareService.getHealthCareByID(id);
    }

    @PutMapping("healthcare/{id}")
    public HealthCare updateHealthCare(@PathVariable Long id, @RequestBody HealthCare newHealthCare) {
        return healthCareService.updateHealthCare(id, newHealthCare);
    }

    @DeleteMapping("healthcares")
    public String deleteAllHeathCare() {
        healthCareService.deleteAllHeathCare();
        return  "All Health Care are been deleted successfully.";
    }


        @DeleteMapping("healthcare/{id}")
    public void deleteHealthCareByID(@PathVariable Long id) {
        healthCareService.deleteHealthCareByID(id);
    }
}
