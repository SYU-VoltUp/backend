package com.syu.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.syu.backend.dto.common.OperatorDto;
import com.syu.backend.enums.ChargerType;
import com.syu.backend.enums.KindDetail;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//@AllArgsConstructor
@ToString
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class StationDto {
    private final String stationId;
    private final String name;
    private final KindDetail kindDetail;
    private final String address;
    private final double lat;
    private final double lng;
    private OperatorDto operator;
    private Set<String> connectorTypes;
    private Set<String> outputs;
    private List<ChargerSummaryDto> chargers;
    public StationDto(String stationId, String operatorId, String operatorName, KindDetail kindDetail, String name, String address, double lat, double lng, String chargerTypes) {
        this.stationId = stationId;
        this.kindDetail = kindDetail;
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.setOperator(operatorId, operatorName);
        this.setConnectorTypes(chargerTypes);
    }
    public StationDto(String stationId, String operatorId, String operatorName, KindDetail kindDetail, String name, String address, double lat, double lng, String chargerTypes, String outputs) {
        this.stationId = stationId;
        this.kindDetail = kindDetail;
        this.name = name;
        this.address = address;
        this.lat = lat;
        this.lng = lng;
        this.setOperator(operatorId, operatorName);
        this.setConnectorTypes(chargerTypes);
        if(outputs != null) {
            this.outputs = Set.of(outputs.split(","));
        }else{
            this.outputs = new HashSet<>();
        }

    }

    private void setConnectorTypes(String types) {
        this.connectorTypes = ChargerType.getConnectorTypesFromChargerCodes(Arrays.asList(types.split(",")));
    }

    private void setOperator(String operatorId, String operatorName) {
        this.operator = new OperatorDto(operatorId, operatorName);
    }

    public void setChargers(List<ChargerSummaryDto> chargers) {
        this.chargers = chargers;
    }
}
//필요한것
//