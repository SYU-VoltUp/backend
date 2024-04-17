package com.syu.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public record CommonResponse(String message, Object data) {
    @Builder
    public CommonResponse {
    }
}
