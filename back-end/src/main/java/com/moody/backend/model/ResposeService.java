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

    public ResponseDto getResponseDto(String latitude, String longitude) {
        // TODO return error if currentWeather null
        CurrentWeather currentWeather = getWeather(latitude, longitude).current_weather();
        int code = currentWeather.weathercode();
        Weather weather = repository.getWeatherByCode(code);
        if(weather == null) {
            return null;
        }

        // TODO Fetch list not index and randomise the one to return
        Genre genre = repository.getGenreByWeather(weather).get(0);
        // TODO Add a DTO converter
        return new ResponseDto(
                weather.getDescription(),
                genre.getName(),
                genre.getMessage(),
                genre.getUpVotes(),
                genre.getId());
    }

    public ResponseDto getResponseDto(int i) {
        Weather weather = repository.getWeatherByCode(i);
        if(weather == null) {
            return null;
        }

        // TODO Fetch list not index and randomise the one to return
        Genre genre = repository.getGenreByWeather(weather).get(0);
        // TODO Add a DTO converter
        return new ResponseDto(
                weather.getDescription(),
                genre.getName(),
                genre.getMessage(),
                genre.getUpVotes(),
                genre.getId());
    }

    public WeatherResponse getWeather(String latitude, String longitude) {
        WebClient webClient = WebClient.create("https://api.open-meteo.com");

        WeatherResponse response = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/v1/forecast")
                        .queryParam("latitude", latitude)
                        .queryParam("longitude", longitude)
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
