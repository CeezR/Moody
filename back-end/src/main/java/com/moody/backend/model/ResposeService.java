package com.moody.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;


import java.util.List;
import java.util.Random;

@Service
public class ResposeService {
    private final ResponseRepository repository;

    @Autowired
    public ResposeService(ResponseRepository repository) {
        this.repository = repository;
    }

    public ResponseDto getResponseDto() {
        // TODO return error if currentWeather null
        CurrentWeather currentWeather = getWeather().current_weather();
        int code = getWeather().current_weather().weathercode();
        Weather weather = repository.getWeatherByCode(code);
        if(weather == null) {
            return null;
        }

        // TODO Fetch list not index and randomise the one to return
        Genre genre = repository.getGenreByWeather(weather).get(0);
        // TODO Add a DTO converter
        return new ResponseDto(weather.getDescription(), genre.getName(), genre.getMessage());
    }

    public ResponseDto getResponseDto(int i) {
        Weather weather = repository.getWeatherByCode(i);
        if(weather == null) {
            return null;
        }

        // TODO Fetch list not index and randomise the one to return
        Genre genre = repository.getGenreByWeather(weather).get(0);
        // TODO Add a DTO converter
        return new ResponseDto(weather.getDescription(), genre.getName(), genre.getMessage());
    }

    public WeatherResponse getWeather() {
        WebClient webClient = WebClient.create("https://api.open-meteo.com");

        WeatherResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("latitude", "59.3294")
                        .queryParam("longitude", "18.0687")
                        .queryParam("current_weather", "true")
                        .queryParam("timezone", "auto")
                        .queryParam("models", "best_match")
                        .build())
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .block();
        System.out.println(response.toString());
        return response;
    }
}
