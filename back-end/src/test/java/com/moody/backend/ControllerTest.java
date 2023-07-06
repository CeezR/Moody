package com.moody.backend;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.MethodOrderer.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    RestTemplate restTemplate;

    @Test
    void shouldCreateCartForPost(){
        String uri = "http://localhost:%s/api".formatted(port);
        ResponseEntity<String> exchange = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, String.class);
        assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.OK);

    }
}