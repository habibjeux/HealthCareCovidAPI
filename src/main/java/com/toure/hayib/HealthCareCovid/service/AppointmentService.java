package com.toure.hayib.HealthCareCovid.service;

import com.toure.hayib.HealthCareCovid.model.Appointment;
import com.toure.hayib.HealthCareCovid.model.Map;
import com.toure.hayib.HealthCareCovid.repository.AppointmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;

    public Appointment createAppointment(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    public List<Appointment> getAllMaps() {
        List<Appointment> appointments = new ArrayList<>();
        appointmentRepository.findAll().forEach(appointments::add);
        return appointments;
    }

    public Optional<Appointment> getAppointmentById(Long id) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent())
            return appointment;
        else
            return null;
    }

    public Appointment updateAppointment(Long id, Appointment newAppointment) {
        Optional<Appointment> appointment = appointmentRepository.findById(id);
        if(appointment.isPresent()) {
            Appointment existingAppointment = appointment.get();
            existingAppointment.setDate(newAppointment.getDate());
            existingAppointment.setDoseType(newAppointment.getDoseType());
            existingAppointment.setHealthCare(newAppointment.getHealthCare());
            existingAppointment.setNotes(newAppointment.getNotes());
            return appointmentRepository.save(existingAppointment);
        }
        return null;
    }

    public void deleteAppointmentById(Long id) {
        appointmentRepository.deleteById(id);
    }

    public void deleteAllAppointments() {
        appointmentRepository.deleteAll();
    }

}
