package com.syu.backend.service;

import com.syu.backend.dto.response.ChargerSummaryDto;
import com.syu.backend.dto.response.StationDto;
import com.syu.backend.repository.ChargerRepository;
import com.syu.backend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class StationCacheService {
    private final StationRepository stationRepository;
    private final ChargerRepository chargerRepository;

    @Transactional(readOnly = true)
    @Cacheable(value = "stations", key = "#geoHash")
    public List<StationDto> getStationSummaries(String geoHash) {
        return stationRepository.findByGeoHash(geoHash);
    }

    @Transactional(readOnly = true)
    @Cacheable(value = "station", key = "#stationId")
    public StationDto getStationDetail(String stationId) {
        StationDto station = stationRepository.findByStationId(stationId)
                .orElseThrow(() -> new NoSuchElementException("Station with code " + stationId + " not found"));
        List<ChargerSummaryDto> chargers = chargerRepository.findAllByStationId(stationId);
        station.setChargers(chargers);
        return station;
    }
}
