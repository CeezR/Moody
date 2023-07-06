package com.moody.backend;

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
        String uri = "http://localhost:%s/api".formatted(port);
        ResponseEntity<ResponseDto> exchange = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, ResponseDto.class);
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(exchange.getBody().genreName()).isNotNull();
        assertThat(exchange.getBody().weatherDescription()).isNotNull();
        assertThat(exchange.getBody().genre_message()).isNotNull();

    }
}