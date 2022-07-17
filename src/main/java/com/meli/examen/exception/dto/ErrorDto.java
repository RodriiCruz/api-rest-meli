package com.meli.examen.exception.dto;

import lombok.Builder;
import lombok.Data;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Builder
@Data
public class ErrorDto {

    private boolean error;
    private String message;
    private Integer code;

}
