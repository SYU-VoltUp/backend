package com.syu.backend.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.stream.Stream;

@JsonPropertyOrder({"code", "type", "connectorTypes"})
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum ChargerType {
    DC_CHA_DEMO("01", "DC차데모", "차데모"),
    AC_NORMAL("02", "AC완속", "이동형"),
    DC_CHA_DEMO_AC_3PHASE("03", "DC차데모+AC3상", "차데모", "AC3상"),
    DC_COMBO("04", "DC콤보", "DC콤보"),
    DC_CHA_DEMO_DC_COMBO("05", "DC차데모+DC콤보", "차데모", "DC콤보"),
    DC_CHA_DEMO_AC_3PHASE_DC_COMBO("06", "DC차데모+AC3상+DC콤보", "차데모", "AC3상", "DC콤보"),
    AC_3PHASE("07", "AC3상", "AC3상"),
    DC_COMBO_NORMAL("08", "DC콤보(완속)", "완속"),
    H2("89", "H2");
    public final String code;
    public final String type;
    public final List<String> connectorTypes;

    ChargerType(String code, String type, String... connectorTypes) {
        this.code = code;
        this.type = type;
        this.connectorTypes = List.of(connectorTypes);
    }

    public static List<ChargerType> getChargerTypes(List<String> connectorTypes) {
        //하나라도 포함되면 반환
        return Stream.of(ChargerType.values())
                .filter(chargerType -> chargerType.getConnectorTypes().stream().anyMatch(connectorTypes::contains))
                .toList();
    }

    public static ChargerType of(String code) {
        return Stream.of(ChargerType.values())
                .filter(chargerType -> chargerType.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown code: " + code));

    }

    public String getCode() {
        return this.code;
    }

    public String getType() {
        return this.type;
    }

    public List<String> getConnectorTypes() {
        return this.connectorTypes;
    }
}
