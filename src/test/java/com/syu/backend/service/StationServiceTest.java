package com.syu.backend.service;

import com.syu.backend.dto.request.StationsQueryParams;
import com.syu.backend.dto.response.StationDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StationServiceTest {
    @Autowired
    private StationService stationService;

    @Test
    void getStationsWithOutCaching() {
        String bounds = "37.53,126.92,37.55,127";
        StationsQueryParams params = StationsQueryParams.builder().bounds(bounds).build();
        long startTime = System.currentTimeMillis();
        List<StationDto> stations = stationService.getStations(params);
        long endTime = System.currentTimeMillis();
        System.out.println("Time: " + (endTime - startTime) + "ms");
        System.out.println("stations count = " + stations.size());
    }

}