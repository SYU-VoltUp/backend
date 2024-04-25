package com.syu.backend.controller.v1;

import com.syu.backend.dto.request.StationsQueryParams;
import com.syu.backend.service.StationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/stations")
public class StationRestControllerV1 {
    private final StationService stationService;

    @GetMapping
    public ResponseEntity<String> getStation(@Valid final StationsQueryParams stationsQueryParams) {
        stationService.getStations(stationsQueryParams);
        return ResponseEntity.ok("Success");
    }
}
