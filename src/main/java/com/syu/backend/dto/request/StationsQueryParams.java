package com.syu.backend.dto.request;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StationsQueryParams {

    private double[] bounds;

    @Builder
    public StationsQueryParams(String bounds) {
        Assert.notNull(bounds, "Bounds must be provided");
        String[] boundsArray = bounds.split(",");
        Assert.isTrue(boundsArray.length == 4, "Bounds must have 4 values");
        this.bounds = new double[4];
        for (int i = 0; i < 4; i++) {
            this.bounds[i] = Double.parseDouble(boundsArray[i]);
        }
        Assert.isTrue(this.bounds[0] < this.bounds[2], "bottomLat must be less than topLat");
        Assert.isTrue(this.bounds[1] < this.bounds[3], "leftLng must be less than rightLng");
    }
}
