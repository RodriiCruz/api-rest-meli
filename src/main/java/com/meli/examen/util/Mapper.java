package com.meli.examen.util;

import java.util.Arrays;

import org.springframework.stereotype.Component;

import com.meli.examen.entity.DNASequence;
import com.meli.examen.entity.dto.AddDnaResponseDto;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Component
public class Mapper {

    public String arrayToString(String[] array) {
        String string = Arrays.toString(array).replaceAll(" ", "").replaceAll(",", "");
        string = string.substring(1, string.length() - 1);

        return string.toUpperCase();
    }

    public char[][] stringToCharMatrix(String string, int size) {
        char[][] matrix = new char[size][size];
        int aux = 0;

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = string.charAt(aux);
                aux++;
            }
        }
        return matrix;
    }

    public AddDnaResponseDto entityToDto(DNASequence entity) {
        return AddDnaResponseDto.builder().id(entity.getId()).dna(entity.getDna()).isMutant(entity.isMutant()).build();
    }
}
