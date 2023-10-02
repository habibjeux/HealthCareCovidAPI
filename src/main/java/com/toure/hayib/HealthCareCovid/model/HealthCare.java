package com.toure.hayib.HealthCareCovid.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "healthcare")
public class HealthCare {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "healthcareid")
    private Long healthcareID;

    private String name;

    private String address;

    private String phone;

    private String email;

    private String type;

    @Column(name = "vaccineavailability")
    private Boolean vaccineAvailability;
    @Column(name = "testavailability")
    private Boolean testAvailability;

    @ManyToOne
    @JoinColumn(name = "map_id")
    private Map map;

}
