package com.syu.backend.controller.v1;


import com.syu.backend.service.ChargerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/chargers")
public class ChargerRestControllerV1 {
    private final ChargerService chargerService;

}

