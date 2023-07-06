package com.moody.backend.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CurrentWeather(
        double temperature,
        double windspeed,
        double winddirection,
        int weathercode,
        int is_day,
        String time
        ) {
}
