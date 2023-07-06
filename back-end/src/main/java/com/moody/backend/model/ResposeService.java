package com.moody.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class ResposeService {
    private final ResponseRepository repository;

    @Autowired
    public ResposeService(ResponseRepository repository) {
        this.repository = repository;
    }

    public ResponseDto getResponseDto(int i) {
        Weather weather = repository.getWeatherByCode(i);
        // TODO Fetch list not index and randomise the one to return
        Genre genre = repository.getGenreByWeather(weather).get(0);
        return new ResponseDto(weather.getDescription(), genre.getName(), genre.getMessage());
    }
}
