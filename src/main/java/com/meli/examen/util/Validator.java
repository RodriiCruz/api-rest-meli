package com.meli.examen.util;

import static com.meli.examen.util.Constants.ADENINE;
import static com.meli.examen.util.Constants.AGCT_LENGTH;
import static com.meli.examen.util.Constants.CYTOSINE;
import static com.meli.examen.util.Constants.ERROR_MSG_WRONG_BASE;
import static com.meli.examen.util.Constants.ERROR_MSG_WRONG_LENGTH;
import static com.meli.examen.util.Constants.GUANINE;
import static com.meli.examen.util.Constants.THYMINE;

import org.springframework.stereotype.Component;

import com.meli.examen.exception.InvalidDnaException;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Component
public class Validator {

    public void checkSample(String[] dnaSequence, int size) {
        if (size < AGCT_LENGTH) {
            throw new InvalidDnaException(ERROR_MSG_WRONG_LENGTH);
        }

        for (String sample : dnaSequence) {

            if (sample.length() != size) {
                throw new InvalidDnaException(ERROR_MSG_WRONG_LENGTH);
            }

            for (int i = 0; i < size; i++) {
                String characters = Character.toString(sample.charAt(i));
                boolean isCorrect = characters.equalsIgnoreCase(Character.toString(ADENINE))
                        || characters.equalsIgnoreCase(Character.toString(THYMINE))
                        || characters.equalsIgnoreCase(Character.toString(CYTOSINE))
                        || characters.equalsIgnoreCase(Character.toString(GUANINE));

                if (!isCorrect) {
                    throw new InvalidDnaException(ERROR_MSG_WRONG_BASE);
                }
            }
        }
    }

}
