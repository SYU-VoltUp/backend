package com.syu.backend.model;

import com.syu.backend.enums.ChargerType;
import com.syu.backend.enums.KindDetail;
import com.syu.backend.enums.converter.ChargerTypeConverter;
import com.syu.backend.enums.converter.KindDetailConverter;
import jakarta.persistence.*;
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

    @Convert(converter = ChargerTypeConverter.class)
    @Column(name = "charger_type", nullable = false)
    private ChargerType chargerType;

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

    @Convert(converter = KindDetailConverter.class)
    @Column(name = "kind_detail", nullable = false)
    private KindDetail kindDetail;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "apt_code", nullable = true)
    private String ApartmentCode;

    @Column(name = "geohash", nullable = true)
    private String geohash;
}
