package com.syu.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syu.backend.enums.ChargerType;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record ChargerSummaryDto(String chargerId, ChargerType chargerType,
                                int output, LocalDateTime updatedAt) {

    public String getOutput() {
        return output + "kW";
    }

}