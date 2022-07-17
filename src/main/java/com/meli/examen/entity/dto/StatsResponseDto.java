package com.meli.examen.entity.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Data
@Builder
public class StatsResponseDto {

    private Long count_mutant_dna;
    private Long count_human_dna;

    public Double getRatio() {
        return count_human_dna > 0 ? Double.valueOf(count_mutant_dna) / Double.valueOf(count_human_dna) : 1;
    }
}
