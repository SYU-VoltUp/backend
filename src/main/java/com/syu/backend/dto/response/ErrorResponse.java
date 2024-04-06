package com.syu.backend.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private int status;
    private String message;
    private String reason;
    @Builder
    public ErrorResponse(int status, String message, String reason) {
        this.status = status;
        this.message = message;
        this.reason = reason;
    }
}
