package com.moody.backend.model;

public record ResponseDto(
        String weatherDescription,
        String genreName,
        String genre_message,
        Long genre_upvotes,
        Long id
        ) {
}
