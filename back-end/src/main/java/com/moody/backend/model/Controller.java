package com.moody.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {
    private final ResposeService service;
    private final ResponseRepository repository;

    @Autowired
    public Controller(ResposeService service, ResponseRepository repository) {
        this.service = service;
        this.repository = repository;
    }


    @GetMapping()
    ResponseEntity<ResponseDto> getWeather(
            @RequestParam("longitude") String longitude,
            @RequestParam("latitude") String latitude) {
        ResponseDto dto = service.getResponseDto(longitude, latitude);
        return ResponseEntity.ok().body(dto);
    }

//    @PostMapping(path = "carts", produces = {MediaType.APPLICATION_JSON_VALUE})
//    ResponseEntity<CartDTO> createCart() {
//        Cart newCart = service.createCart();
//        if (newCart == null) {
//            return ResponseEntity.internalServerError().build();
//        }
//        URI location = URI.create("/api/carts/" + newCart.getId());
//        return ResponseEntity.created(location).body(service.getCartDto(newCart));
//    }

    @PutMapping(path = "genre/{id}/upVote")
    ResponseEntity<Void> upVoteGenre(@PathVariable Long id) {
        Genre genre = repository.getGenre(id);
        if(genre == null) {
            return ResponseEntity.notFound().build();
        }
        repository.upVoteGenre(genre.getId());
        return ResponseEntity.ok().build();
    }

    @PutMapping(path = "genre/{id}/downVote")
    ResponseEntity<Void> downVoteGenre(@PathVariable Long id) {
        Genre genre = repository.getGenre(id);
        if(genre == null) {
            return ResponseEntity.notFound().build();
        }
        repository.downVoteGenre(genre.getId());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(path = "genre/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    ResponseEntity<Void> deleteCart(@PathVariable Long id) {
        try {
            repository.deleteGenreById(id);
        } catch (EmptyResultDataAccessException ignored) {}

        return ResponseEntity.noContent().build();
    }
}
