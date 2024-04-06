package com.syu.backend.handler;

import com.syu.backend.dto.response.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    protected ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        log.error("IllegalArgumentException", e);
        ErrorResponse errorResponse = ErrorResponse.builder()
                .status(400)
                .reason(e.getMessage())
                .message("잘못된 요청입니다.")
                .build();
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
