package com.meli.examen.entity.dto;

import javax.validation.constraints.NotNull;

import lombok.Data;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Data
public class AddDnaRequestDto {

    @NotNull
    String[] dna;
}
