package com.meli.examen.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.meli.examen.entity.DNASequence;
import com.meli.examen.entity.dto.AddDnaRequestDto;
import com.meli.examen.entity.dto.AddDnaResponseDto;
import com.meli.examen.entity.dto.StatsResponseDto;
import com.meli.examen.repository.IDNASequenceRepository;
import com.meli.examen.service.IDnaAnalizer;
import com.meli.examen.service.IMutantDetectorService;
import com.meli.examen.util.Mapper;
import com.meli.examen.util.Validator;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Service
public class MutantDetectorServiceImpl implements IMutantDetectorService {

    private Validator validator;
    private Mapper mapper;
    private IDnaAnalizer analizer;
    private IDNASequenceRepository repository;

    public MutantDetectorServiceImpl(Validator validator, Mapper mapper, IDnaAnalizer analizer,
            IDNASequenceRepository repository) {
        this.validator = validator;
        this.mapper = mapper;
        this.analizer = analizer;
        this.repository = repository;
    }

    @Override
    public boolean isMutant(String[] dna) {
        int sampleSize = dna[0].length();
        int sequencesFound = 0;
        validator.checkSample(dna, sampleSize);

        String sample = mapper.arrayToString(dna);
        char[][] matrix = mapper.stringToCharMatrix(sample, sampleSize);

        sequencesFound += analizer.analizeDna(matrix);
        return sequencesFound > 1;
    }

    @Override
    public AddDnaResponseDto saveSample(AddDnaRequestDto dto) {
        String sample = mapper.arrayToString(dto.getDna());
        Optional<DNASequence> result = repository.findByDna(sample);
        DNASequence dnaSequence = null;

        if (result.isEmpty()) {
            dnaSequence = repository
                    .save(DNASequence.builder().dna(sample).isMutant(this.isMutant(dto.getDna())).build());
        } else {
            dnaSequence = result.get();
        }

        return mapper.entityToDto(dnaSequence);
    }

    @Override
    public StatsResponseDto getStats() {
        Long total = repository.count();
        Long areMutants = repository.findAll().stream().filter(sample -> sample.isMutant()).count();
        Long areHumans = total - areMutants;

        StatsResponseDto response = StatsResponseDto.builder().count_mutant_dna(areMutants).count_human_dna(areHumans)
                .build();

        return response;
    }

}
