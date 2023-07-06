package com.moody.backend;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {

    @GetMapping
    ResponseEntity<ResponseDto> getTest() {
        return ResponseEntity.ok().body(new ResponseDto(null, null, null));
    }
}
