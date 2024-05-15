package com.syu.backend.service;

import com.syu.backend.dto.request.StationsQueryParams;
import com.syu.backend.dto.response.StationDto;
import com.syu.backend.repository.StationRepository;
import com.syu.backend.util.MapUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class StationService {
    private final MapUtil mapUtil;
    private final StationRepository stationRepository;
    private final StationCacheService stationCacheService;

    @Transactional(readOnly = true)
    public List<StationDto> getStations(StationsQueryParams stationsQueryParams) {
        double[] bounds = stationsQueryParams.getBounds();
        Set<String> geoHashes = mapUtil.getCoverGeohashes(bounds[0], bounds[1], bounds[2], bounds[3]);
        log.debug("geoHashes: {}", geoHashes);
        Stream<StationDto> stationsStream = geoHashes.stream()
                .flatMap(geoHash -> {
                    List<StationDto> summaries = stationCacheService.getStationSummaries(geoHash);
                    return summaries != null ? summaries.stream() : Stream.empty();
                });

        //충전 속도 필터링
        if (stationsQueryParams.getOutputs() != null) {
            Set<String> outputs = stationsQueryParams.getOutputs();
            if (!outputs.isEmpty()) {
                stationsStream = stationsStream.filter(station ->
                        station.getOutputs() != null && !Collections.disjoint(station.getOutputs(), outputs)
                );
            }
        }
        //충전 타입 필터링
        if (stationsQueryParams.getTypes() != null) {
            Set<String> types = stationsQueryParams.getTypes();
            if(!types.isEmpty()) {
                stationsStream = stationsStream.filter(station ->
                        station.getConnectorTypes() != null && !Collections.disjoint(station.getConnectorTypes(), types)
                );
            }
        }
        return stationsStream.toList();
    }

    private List<StationDto> getStationsByGeoHashes(Set<String> geoHashes) {
        return stationRepository.findAllByGeoHashes(geoHashes);
    }


    public StationDto getStation(String stationId) {
        return stationCacheService.getStationDetail(stationId);
    }
}
