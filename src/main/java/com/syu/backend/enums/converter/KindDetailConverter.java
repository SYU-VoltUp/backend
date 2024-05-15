package com.syu.backend.enums.converter;

import com.syu.backend.enums.KindDetail;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class KindDetailConverter implements AttributeConverter<KindDetail, String> {

    @Override
    public String convertToDatabaseColumn(KindDetail kindDetail) {
        if (kindDetail == null) {
            return null;
        }
        return kindDetail.getCode();
    }

    @Override
    public KindDetail convertToEntityAttribute(String code) {
        return KindDetail.fromCode(code);
    }
}
