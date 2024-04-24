package com.syu.backend.repository;

import com.syu.backend.dto.response.StationDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class StationRepositoryTest {

    @Autowired
    private StationRepository stationRepository;

    @DisplayName("geohash list 를 이용한 충전소 조회 테스트")
    @Test
    void findAllByGeoHashes() {
        List<String> geoHashes = new ArrayList<>();
        geoHashes.add("wydm82");
        geoHashes.add("wydhq7");
        List<StationDto> stationList = stationRepository.findAllByGeoHashes(geoHashes);
        System.out.println("stationList = " + stationList);
        assertThat(!stationList.isEmpty());
    }

    @DisplayName("stationId 를 이용한 충전소 조회 테스트")
    @Test
    void findByStationId() {
        String stationId = "ACAC0001";
        StationDto station = stationRepository.findByStationId(stationId).orElse(null);
        System.out.println("station = " + station);
        assertThat(station != null);
    }
}