package com.moody.backend.model;

import com.moody.backend.model.ResponseDto;
import com.moody.backend.model.ResposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {
    private final ResposeService service;

    @Autowired
    public Controller(ResposeService service) {
        this.service = service;
    }


    @GetMapping
    ResponseEntity<ResponseDto> getTest() {
        return ResponseEntity.ok().body(new ResponseDto(null, null, null));
    }
}
