package com.toure.hayib.HealthCareCovid.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "map")
public class Map {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "mapid")
    private Long mapID;

    private BigDecimal latitude;

    private BigDecimal longitude;
}
