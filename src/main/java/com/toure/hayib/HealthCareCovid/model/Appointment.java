package com.toure.hayib.HealthCareCovid.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "appointmentid")
    private Long appointmentID;

    private Date date;
    @Column(name = "dosetype")
    private String doseType;

    private String notes;

    @ManyToOne
    @JoinColumn(name="healthcare_id")
    private HealthCare healthCare;
}
