package com.meli.examen.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.meli.examen.entity.dto.AddDnaRequestDto;
import com.meli.examen.entity.dto.AddDnaResponseDto;
import com.meli.examen.service.IMutantDetectorService;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@RestController
public class MutantDetectorController {

    private IMutantDetectorService service;

    public MutantDetectorController(IMutantDetectorService service) {
        this.service = service;
    }

    @PostMapping("/mutant")
    public ResponseEntity<?> save(@Valid @RequestBody AddDnaRequestDto dto) {
        AddDnaResponseDto response = service.saveSample(dto);
        return response.isMutant() ? ResponseEntity.status(HttpStatus.OK).body(response)
                : ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
    }

}
