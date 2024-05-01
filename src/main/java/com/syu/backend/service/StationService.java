package com.syu.backend.service;

import com.syu.backend.dto.request.StationsQueryParams;
import com.syu.backend.dto.response.StationDto;
import com.syu.backend.repository.StationRepository;
import com.syu.backend.util.MapUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
@RequiredArgsConstructor
public class StationService {
    private final MapUtil mapUtil;
    private final StationRepository stationRepository;

    public List<StationDto> getStations(StationsQueryParams stationsQueryParams) {
        double[] bounds = stationsQueryParams.getBounds();
        Set<String> geoHashes = mapUtil.getCoverGeohashes(bounds[0], bounds[1], bounds[2], bounds[3]);
        log.debug("geoHashes: {}", geoHashes);
        List<StationDto> stations = geoHashes.stream()
                .flatMap(geoHash -> getStationByGeoHash(geoHash).stream())
                .toList();


        return stations;
    }

    private List<StationDto> getStationsByGeoHashes(Set<String> geoHashes) {
        return stationRepository.findAllByGeoHashes(geoHashes);
    }

    private List<StationDto> getStationByGeoHash(String geoHash) {
        return stationRepository.findByGeoHash(geoHash);
    }
}
