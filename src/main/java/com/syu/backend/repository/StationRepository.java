package com.syu.backend.repository;

import com.syu.backend.dto.response.StationDto;
import com.syu.backend.model.Charger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface StationRepository extends JpaRepository<Charger, String> {

    @Query("SELECT " +
            "NEW com.syu.backend.dto.response.StationDto( " +
            "SUBSTRING(c.chargerId, 1,locate('-',c.chargerId)-1)," +
            "   c.operatorId,c.operatorName, c.kindDetail, c.name,c.address,c.latitude,c.longitude," +
            "cast(group_concat(distinct(c.chargerType)) as string))" +
            "FROM Charger c WHERE c.geohash IN (:geoHashes)" +
            "GROUP BY SUBSTRING(c.chargerId, 1,locate('-',c.chargerId)-1)")
    List<StationDto> findAllByGeoHashes(@Param("geoHashes") Set<String> geoHashes);

    @Query("SELECT " +
            "NEW com.syu.backend.dto.response.StationDto( " +
            "SUBSTRING(c.chargerId, 1,locate('-',c.chargerId)-1)," +
            "   c.operatorId,c.operatorName, c.kindDetail, c.name,c.address,c.latitude,c.longitude," +
            "cast(group_concat(distinct(c.chargerType)) as string))" +
            "FROM Charger c WHERE c.geohash LIKE CONCAT(:geoHash,'%')" +
            "GROUP BY SUBSTRING(c.chargerId, 1,locate('-',c.chargerId)-1)")
    List<StationDto> findByGeoHash(@Param("geoHash") String geoHash);

    @Query("SELECT " +
            "NEW com.syu.backend.dto.response.StationDto( " +
            "SUBSTRING(c.chargerId, 1, locate('-',c.chargerId)-1)," +
            "   c.operatorId, c.operatorName, c.kindDetail, c.name, c.address, c.latitude, c.longitude," +
            "cast(group_concat(distinct(c.chargerType)) as string))" +
            "FROM Charger c WHERE c.chargerId LIKE CONCAT(:stationId, '%')" +
            "GROUP BY SUBSTRING(c.chargerId, 1, locate('-', c.chargerId)-1)")
    Optional<StationDto> findByStationId(@Param("stationId") String stationId);
}
