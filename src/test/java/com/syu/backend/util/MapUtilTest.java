package com.syu.backend.util;

import com.syu.backend.dto.common.Position;
import com.syu.backend.repository.ChargerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MapUtilTest {
    @Autowired
    private MapUtil mapUtil;
    @Autowired
    private ChargerRepository chargerRepository;

    @Test
    public void positionToGeohashTest() {
        double latitude = 38.1163;
        double longitude = 128.632;
        Position position = new Position(latitude, longitude);
        String hash = mapUtil.getGeohash(position);
        System.out.println("hashValue: " + hash);
    }

    @Test
    public void getCoverGeohashesTest() {
        double topLeftLat = 33.47610124042895;      // 서울의 최북단 위도
        double topLeftLng = 126.5079721228214;     // 서울의 최서단 경도
        double bottomRightLat = 33.425177960862264;  // 서울의 최남단 위도
        double bottomRightLng = 126.63317250128318; // 서울의 최동단 경도

        System.out.println(mapUtil.getCoverGeohashes(topLeftLat, topLeftLng, bottomRightLat, bottomRightLng));
    }

}