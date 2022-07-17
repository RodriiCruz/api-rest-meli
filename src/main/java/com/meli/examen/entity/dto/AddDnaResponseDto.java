package com.meli.examen.entity.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Data
@Builder
public class AddDnaResponseDto {

    private Long id;
    private String dna;
    private boolean isMutant;

}
