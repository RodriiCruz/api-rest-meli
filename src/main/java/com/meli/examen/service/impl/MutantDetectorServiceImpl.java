package com.meli.examen.service.impl;

import com.meli.examen.service.IMutantDetectorService;
import com.meli.examen.util.Mapper;
import com.meli.examen.util.Validator;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class MutantDetectorServiceImpl implements IMutantDetectorService {

    private Validator validator;
    private Mapper mapper;
    private DnaAnalizerImpl analizer;

    public MutantDetectorServiceImpl() {
        this.validator = new Validator();
        this.mapper = new Mapper();
        this.analizer = new DnaAnalizerImpl();
    }

    @Override
    public boolean isMutant(String[] dnaSequence) {
        int sampleSize = dnaSequence[0].length();
        int sequencesFound = 0;
        validator.checkSample(dnaSequence, sampleSize);

        String sample = mapper.arrayToString(dnaSequence);
        char[][] matrix = mapper.stringToCharMatrix(sample, sampleSize);

        sequencesFound += analizer.analizeDna(matrix);
        return sequencesFound > 1;
    }

}
