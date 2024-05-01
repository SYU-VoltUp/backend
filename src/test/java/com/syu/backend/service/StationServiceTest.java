package com.syu.backend.service;

import com.syu.backend.dto.request.StationsQueryParams;
import com.syu.backend.dto.response.StationDto;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class StationServiceTest {
    private final int expectedCount = 793;
    @Autowired
    private StationService stationService;

    // result: Time: 448ms, stations count = 793
    @Test
    @DisplayName("캐싱 없이 충전소 조회 테스트")
    @Order(1)
    void getStationsWithOutCaching() {
        String bounds = "37.53,126.92,37.55,127";
        StationsQueryParams params = StationsQueryParams.builder().bounds(bounds).build();
        long startTime = System.currentTimeMillis();
        List<StationDto> stations = stationService.getStations(params);
        long endTime = System.currentTimeMillis();
        assertThat(stations.size()).isEqualTo(this.expectedCount);
        System.out.println("Time: " + (endTime - startTime) + "ms");
        System.out.println("stations count = " + stations.size());
    }

    // result: Time: 8ms, stations count = 793
    @Test
    @DisplayName("캐싱을 이용한 충전소 조회 테스트")
    @Order(2)
    void getStationsWithCaching() {
        String bounds = "37.53,126.92,37.55,127";
        StationsQueryParams params = StationsQueryParams.builder().bounds(bounds).build();
        long startTime = System.currentTimeMillis();
        List<StationDto> stations = stationService.getStations(params);
        long endTime = System.currentTimeMillis();
        assertThat(stations.size()).isEqualTo(this.expectedCount);
        System.out.println("Time: " + (endTime - startTime) + "ms");
        System.out.println("stations count = " + stations.size());
    }

}