package com.moody.backend.model;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ResponseRepositoryTest {

    @Autowired
    private ResponseRepository repo;

    @Test
    void shouldGetWeatherList() {
        List<Weather> weatherList = repo.getWeatherList();
        assertThat(weatherList).isNotNull();
        assertThat(weatherList.size()).isEqualTo(6);
    }

    @Test
    void shouldGetCorrectWeatherByWeatherCode() {
        int code = 1;
        Weather weather = repo.getWeatherByCode(code);
        assertThat(weather).isNotNull();
        assertThat(weather.getDescription()).isEqualTo("Sunny");
    }

    @Test
    void shouldGetCorrectGenreByWeatherId() {
        int code = 1;
        Weather weather = repo.getWeatherByCode(code);
        assertThat(weather).isNotNull();

        List<Genre> genres = repo.getGenreByWeather(weather);
        assertThat(genres).isNotNull();
        assertThat(genres.size()).isEqualTo(1);
        assertThat(genres.get(0).getName()).isEqualTo("Pop");
        assertThat(genres.get(0).getMessage()).isEqualTo("Suns out! Time for some pop to brighten your day even more.");
    }

    @Test
    void shouldDeleteGenre() {
        List<Genre> genreList = repo.getGenreList();
        assertThat(genreList).isNotNull();

        repo.deleteGenreById(1L);

        List<Genre> genreList2 = repo.getGenreList();
        assertThat(genreList2).isNotNull();
        assertThat(genreList2.size()).isEqualTo(genreList.size() - 1);
    }

    @Test
    void shouldUpvoteGenre() {
        Weather weather = repo.getWeatherByCode(1);
        Genre genre = repo.getGenreByWeather(weather).get(0);
        Genre genre2 = repo.upVoteGenre(genre.getId());
        assertThat(genre.getUpVotes() + 1).isEqualTo(genre2.getUpVotes());
    }

    @Test
    void shouldDownvoteGenre() {
        Weather weather = repo.getWeatherByCode(1);
        Genre genre = repo.getGenreByWeather(weather).get(0);
        Genre genre2 = repo.downVoteGenre(genre.getId());
        assertThat(genre.getUpVotes() - 1).isEqualTo(genre2.getUpVotes());
    }

}