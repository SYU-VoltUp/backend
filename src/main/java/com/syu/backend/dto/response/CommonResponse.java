package com.syu.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;


@JsonInclude(JsonInclude.Include.NON_NULL)
public record CommonResponse(String message, Object data) {
    @Builder
    public CommonResponse {
    }
}
