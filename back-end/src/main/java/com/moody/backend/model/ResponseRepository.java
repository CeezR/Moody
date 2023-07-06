package com.moody.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ResponseRepository {
    private final JpaGenreRepository genreRepository;
    private final JpaWeatherRepository weatherRepository;

    @Autowired
    public ResponseRepository(JpaGenreRepository genreRepository, JpaWeatherRepository weatherRepository) {
        this.genreRepository = genreRepository;
        this.weatherRepository = weatherRepository;
    }
}
