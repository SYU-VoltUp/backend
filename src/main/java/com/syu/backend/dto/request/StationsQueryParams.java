package com.syu.backend.dto.request;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.util.Assert;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StationsQueryParams {
    //화면 bounds
    private double[] bounds;
    //충전 속도
    private Set<String> outputs;
    //충전 타입
    private Set<String> types;

    private String keyword;
    //TODO: 세부 필터 구현

    @Builder
    public StationsQueryParams(String bounds, String outputs, String types, String keyword) {
        if (bounds != null) {
            String[] boundsArray = bounds.split(",");
            Assert.isTrue(boundsArray.length == 4, "Bounds must have 4 values");
            this.bounds = new double[4];
            for (int i = 0; i < 4; i++) {
                this.bounds[i] = Double.parseDouble(boundsArray[i]);
            }
            Assert.isTrue(this.bounds[0] < this.bounds[2], "bottomLat must be less than topLat");
            Assert.isTrue(this.bounds[1] < this.bounds[3], "leftLng must be less than rightLng");
        }

        if (outputs != null) {
            this.outputs = Set.of(outputs.split(","));
        }

        if (types != null) {
            this.types = Set.of(types.split(","));
        }
        this.keyword = keyword;
    }


}
