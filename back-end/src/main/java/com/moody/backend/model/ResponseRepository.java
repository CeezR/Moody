package com.moody.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ResponseRepository {
    private final JpaGenreRepository genreRepository;
    private final JpaWeatherRepository weatherRepository;

    @Autowired
    public ResponseRepository(JpaGenreRepository genreRepository, JpaWeatherRepository weatherRepository) {
        this.genreRepository = genreRepository;
        this.weatherRepository = weatherRepository;
    }

    public Weather getWeatherByCode(int code) {
        return weatherRepository.findByWeatherCode(code);
    }

    public List<Genre> getGenreByWeather(Weather weather) {
        return genreRepository.findByWeather(weather);
    }
}
