package com.syu.backend.controller.v1;


import com.syu.backend.dto.response.ChargerDto;
import com.syu.backend.dto.response.CommonResponse;
import com.syu.backend.enums.KindDetail;
import com.syu.backend.service.ChargerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/chargers")
public class ChargerRestControllerV1 {
    private final ChargerService chargerService;

    @GetMapping("/{chargerId}")
    public ResponseEntity<CommonResponse> getCharger(@PathVariable String chargerId) {
        ChargerDto chargerDto = chargerService.getCharger(chargerId);
        return ResponseEntity.ok(CommonResponse.builder()
                .message("Success")
                .data(chargerDto)
                .build());
    }

    @GetMapping("/test")
    public ResponseEntity<CommonResponse> test() {
        return ResponseEntity.ok(CommonResponse.builder()
                .message("Success")
                .data(KindDetail.J004)
                .build());
    }
}

