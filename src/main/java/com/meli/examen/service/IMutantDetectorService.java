package com.meli.examen.service;

import com.meli.examen.entity.dto.AddDnaRequestDto;
import com.meli.examen.entity.dto.AddDnaResponseDto;
import com.meli.examen.entity.dto.StatsResponseDto;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public interface IMutantDetectorService {

    public boolean isMutant(String[] dna);

    public AddDnaResponseDto saveSample(AddDnaRequestDto dto);

    public StatsResponseDto getStats();
}
