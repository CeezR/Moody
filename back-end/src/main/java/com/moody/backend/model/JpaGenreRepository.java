package com.moody.backend.model;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JpaGenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findByWeather(Weather weather);
}
