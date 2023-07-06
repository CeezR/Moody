package com.moody.backend.model;

import com.moody.backend.model.ResponseDto;
import com.moody.backend.model.ResposeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller {
    private final ResposeService service;

    @Autowired
    public Controller(ResposeService service) {
        this.service = service;
    }


    @GetMapping()
    ResponseEntity<ResponseDto> getTest(
            @RequestParam("longitude") String longitude,
            @RequestParam("latitude") String latitude) {
        ResponseDto dto = service.getResponseDto(longitude, latitude);
        return ResponseEntity.ok().body(dto);
    }
}
