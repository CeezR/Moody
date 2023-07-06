package com.moody.backend.model;

import com.moody.backend.model.ResponseDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    RestTemplate restTemplate;

    @Test
    void shouldReturnResponseDtoWithNoNulls(){
        String uri = "http://localhost:%s/api?longitude=59.3294&latitude=18.0687".formatted(port);
        ResponseEntity<ResponseDto> exchange = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, ResponseDto.class);
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(exchange.getBody().genreName()).isNotNull();
        assertThat(exchange.getBody().weatherDescription()).isNotNull();
        assertThat(exchange.getBody().genre_message()).isNotNull();
        assertThat(exchange.getBody().genre_upvotes()).isNotNull();
        assertThat(exchange.getBody().id()).isNotNull();
    }

    @Test
    void shouldUpVoteGenere(){
        String uri = "http://localhost:%s/api/genre/1/upVote".formatted(port);
        ResponseEntity<ResponseDto> exchange = restTemplate.exchange(uri, HttpMethod.PUT, HttpEntity.EMPTY, ResponseDto.class);
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldDownVoteGenere(){
        String uri = "http://localhost:%s/api/genre/1/downVote".formatted(port);
        ResponseEntity<ResponseDto> exchange = restTemplate.exchange(uri, HttpMethod.PUT, HttpEntity.EMPTY, ResponseDto.class);
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void shouldDeleteGenere(){
        String uri = "http://localhost:%s/api/genre/1".formatted(port);
        ResponseEntity<ResponseDto> exchange = restTemplate.exchange(uri, HttpMethod.DELETE, HttpEntity.EMPTY, ResponseDto.class);
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.NO_CONTENT);
    }
}