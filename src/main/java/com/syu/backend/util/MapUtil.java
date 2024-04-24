package com.syu.backend.util;

import com.github.davidmoten.geo.Coverage;
import com.github.davidmoten.geo.GeoHash;
import com.syu.backend.dto.common.Position;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MapUtil {
    private static final int PRECISION = 12;

    public String getGeohash(Position position) {
        return GeoHash.encodeHash(position.getLat(), position.getLng(), PRECISION);
    }

    public Set<String> getCoverGeohashes(double topLat, double leftLng, double bottomLat, double rightLng) {

        Coverage coverage = GeoHash.coverBoundingBoxMaxHashes(topLat, leftLng, bottomLat, rightLng, 12);
        return coverage.getHashes();
    }
}
