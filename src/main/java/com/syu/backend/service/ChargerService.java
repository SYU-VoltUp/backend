package com.syu.backend.service;

import com.syu.backend.dto.response.ChargerDto;
import com.syu.backend.model.Charger;
import com.syu.backend.repository.ChargerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class ChargerService {
    private final ChargerRepository chargerRepository;

    public ChargerDto getCharger(String chargerId) {
        Charger charger = chargerRepository.findById(chargerId)
                .orElseThrow(() -> new NoSuchElementException("Charger with code " + chargerId + " not found"));
        return ChargerDto.of(charger);

    }

}
