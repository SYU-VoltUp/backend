package com.syu.backend.enums.converter;

import com.syu.backend.enums.ChargerType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ChargerTypeConverter implements AttributeConverter<ChargerType, String> {

    @Override
    public String convertToDatabaseColumn(ChargerType chargerType) {
        return chargerType.getCode();
    }

    @Override
    public ChargerType convertToEntityAttribute(String code) {
        return ChargerType.of(code);
    }
}
