package com.moody.backend.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResposeService {
    private final ResponseRepository repository;

    @Autowired
    public ResposeService(ResponseRepository repository) {
        this.repository = repository;
    }

    public ResponseDto getResponseDto(int i) {
        return null;
    }
}
