package com.moody.backend.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ResposeServiceTest {

    @Autowired
    private ResposeService resposeService;

    @Test
    void shouldGetCorrectResponseDtoFromWeatherCode() {

        ResponseDto dto = resposeService.getResponseDto(1);
        assertThat(dto).isNotNull();
        assertThat(dto.weatherDescription()).isEqualTo("Sunny");
        assertThat(dto.genreName()).isEqualTo("Pop");
        assertThat(dto.genre_message()).isEqualTo("Suns out! Time for some pop to brighten your day even more.");
    }

    @Test
    void shouldReturnNullIfWeatherCodeIsNotFound() {
        ResponseDto dto = resposeService.getResponseDto(100);
        assertThat(dto).isNull();
    }

    @Test
    void shouldGetCurrentWeather() {
        // TODO Moch the WeatherEndPoint
        WeatherResponse response = resposeService.getWeather();
        CurrentWeather currentWeather = response.current_weather();
        assertThat(currentWeather).isNotNull();
        assertThat(currentWeather.weathercode()).isNotNull();
    }

}