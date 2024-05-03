package com.syu.backend.repository;

import com.syu.backend.dto.response.ChargerSummaryDto;
import com.syu.backend.model.Charger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChargerRepository extends JpaRepository<Charger, String> {

    @Query("SELECT " +
            "NEW com.syu.backend.dto.response.ChargerSummaryDto(" +
            "c.chargerId, c.chargerType, c.output, c.updatedAt)" +
            "FROM Charger c WHERE c.chargerId LIKE CONCAT(:stationId, '%')")
    List<ChargerSummaryDto> findAllByStationId(@Param("stationId") String stationId);
}
