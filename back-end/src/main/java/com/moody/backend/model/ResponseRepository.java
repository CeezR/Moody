package com.moody.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.StreamSupport;

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

    public List<Weather> getWeatherList() {
        return StreamSupport.stream(weatherRepository.findAll().spliterator(), false).toList();
    }

    public List<Genre> getGenreList() {
        return StreamSupport.stream(genreRepository.findAll().spliterator(), false).toList();
    }

    public void deleteGenreById(Long i) {
        genreRepository.deleteById(i);
    }
}
