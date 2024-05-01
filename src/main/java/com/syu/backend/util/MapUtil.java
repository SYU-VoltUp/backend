package com.syu.backend.util;

import com.github.davidmoten.geo.Coverage;
import com.github.davidmoten.geo.GeoHash;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class MapUtil {
    private static final int PRECISION = 12;

    public String getGeohash(double lat, double lng) {
        return GeoHash.encodeHash(lat, lng, PRECISION);
    }

    public Set<String> getCoverGeohashes(double bottomLat, double leftLng, double topLat, double rightLng) {

        Coverage coverage = GeoHash.coverBoundingBoxMaxHashes(topLat, leftLng, bottomLat, rightLng, 12);
        return coverage.getHashes();
    }
}
