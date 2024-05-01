package com.syu.backend.service;

import com.syu.backend.dto.response.StationDto;
import com.syu.backend.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StationCacheService {
    private final StationRepository stationRepository;

    @Transactional(readOnly = true)
    @Cacheable(value = "stations", key = "#geoHash")
    public List<StationDto> getStationByGeoHash(String geoHash) {
        return stationRepository.findByGeoHash(geoHash);
    }
}
