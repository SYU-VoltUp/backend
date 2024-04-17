package com.syu.backend.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class ChargerTypeTest {
    @DisplayName("커넥터 타임으로 충전기 타입 목록 가져오기 테스트")
    @Test
    void getConnectorTypes() {
        List<String> connectorTypes = List.of("차데모");
        List<ChargerType> chargerTypes = ChargerType.getChargerTypes(connectorTypes);
        System.out.println("chargerTypes = " + chargerTypes);
    }
}