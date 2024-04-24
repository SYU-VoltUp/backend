package com.syu.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syu.backend.dto.common.OperatorDto;
import com.syu.backend.enums.ChargerType;
import com.syu.backend.enums.KindDetail;
import com.syu.backend.model.Charger;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChargerDto(String chargerId, String name, ChargerType chargerType, String address, double lat,
                         double lng, OperatorDto operator, int output, int zscode,
                         KindDetail kindDetail, LocalDateTime updatedAt, String ApartmentCode) {
    public static ChargerDto of(Charger charger) {
        return new ChargerDto(charger.getChargerId(), charger.getName(), charger.getChargerType(), charger.getAddress(),
                charger.getLatitude(), charger.getLongitude(), new OperatorDto(charger.getOperatorId(), charger.getOperatorName()),
                charger.getOutput(), charger.getZscode(), charger.getKindDetail(), charger.getUpdatedAt(),
                charger.getApartmentCode());
    }

    public String getOutput() {
        return output + "kW";
    }

}