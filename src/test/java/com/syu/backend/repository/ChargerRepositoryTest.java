package com.syu.backend.repository;

import com.syu.backend.model.Charger;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class ChargerRepositoryTest {
    @Autowired
    private ChargerRepository chargerRepository;

    @DisplayName("충전기 조회 테스트")
    @Test
    @Order(1)
    void findByChargerIdTest() {
        //Target chargerId
        final String chargerId = "ACAC0001-01";
        Optional<Charger> chargerOptional = chargerRepository.findById(chargerId);
        assertThat(chargerOptional.isPresent());
    }

}