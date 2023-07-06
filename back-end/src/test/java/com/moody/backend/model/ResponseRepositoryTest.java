package com.moody.backend.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ResponseRepositoryTest {

    @Autowired
    private ResponseRepository repo;

    @Test
    void shouldGetCorrectWeatherByWeatherCode() {
        int code = 1;
        Weather weather = repo.getWeatherByCode(code);
        assertThat(weather).isNotNull();
        assertThat(weather.getDescription()).isEqualTo("Sunny");
    }



}