package com.syu.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Charger {
    @Id
    @Column(name = "station_charger_id", length = 20, nullable = false)
    private String chargerId;

    @Column(name = "name", length = 200, nullable = false)
    private String name;

    @Column(name = "charger_type", nullable = false)
    private int chargerType;

    @Column(name = "address", length = 200, nullable = false)
    private String address;

    @Column(name = "lat", nullable = false)
    private double latitude;

    @Column(name = "lng", nullable = false)
    private double longitude;

    @Column(name = "operator_id", nullable = false)
    private String operatorId;

    @Column(name = "operator_name", nullable = false)
    private String operatorName;

    @Column(name = "output", nullable = false)
    private int output;

    @Column(name = "zscode", nullable = false)
    private int zscode;

    @Column(name = "kind_detail", nullable = false)
    private String kindDetail;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "apt_code", nullable = true)
    private String ApartmentCode;
}
