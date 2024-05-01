package com.syu.backend.dto.response;

import com.syu.backend.dto.common.OperatorDto;
import com.syu.backend.enums.ChargerType;
import com.syu.backend.enums.KindDetail;
import lombok.Getter;
import lombok.ToString;

import java.util.Arrays;
import java.util.Set;

//@AllArgsConstructor
@ToString
@Getter
public class StationDto {
    private final String stationId;
    private final String name;
    private OperatorDto operator;
    private final KindDetail kindDetail;
    private final String address;
    private final double lat;
    private final double lng;
    private Set<String> connectorTypes;

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

    private void setConnectorTypes(String types) {
        this.connectorTypes = ChargerType.getConnectorTypesFromChargerCodes(Arrays.asList(types.split(",")));
    }

    private void setOperator(String operatorId, String operatorName) {
        this.operator = new OperatorDto(operatorId, operatorName);
    }
}
//필요한것
//