package com.toure.hayib.HealthCareCovid.controller;

import com.toure.hayib.HealthCareCovid.model.Appointment;
import com.toure.hayib.HealthCareCovid.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;

    @PostMapping("appointment")
    public Appointment createAppointment(@RequestBody Appointment appointment) {
        return appointmentService.createAppointment(appointment);
    }

    @GetMapping("appointments")
    public List<Appointment> getAllMaps() {
        return  appointmentService.getAllMaps();
    }

    @GetMapping("appointment/{id}")
    public Optional<Appointment> getAppointmentById(@PathVariable Long id) {
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping("appointment/{id}")
    public Appointment updateAppointment(@PathVariable Long id, @RequestBody Appointment newAppointment) {
        return appointmentService.updateAppointment(id, newAppointment);
    }

    @DeleteMapping("appointment/{id}")
    public void deleteAppointmentById(@PathVariable Long id) {
        appointmentService.deleteAppointmentById(id);
    }

    @DeleteMapping("appointments")
    public String deleteAllAppointments() {
        appointmentService.deleteAllAppointments();
        return "All Appointments are deleted successfully.";
    }

}
