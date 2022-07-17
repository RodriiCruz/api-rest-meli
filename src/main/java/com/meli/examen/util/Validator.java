package com.meli.examen.util;

import static com.meli.examen.util.Constants.ADENINE;
import static com.meli.examen.util.Constants.AGCT_LENGTH;
import static com.meli.examen.util.Constants.CYTOSINE;
import static com.meli.examen.util.Constants.GUANINE;
import static com.meli.examen.util.Constants.THYMINE;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
public class Validator {

    public void checkSample(String[] dnaSequence, int size) {
        if (size < AGCT_LENGTH) {
            // throw exception
        }

        for (String sample : dnaSequence) {

            if (sample.length() != size) {
                // throw exception
            }

            for (int i = 0; i < size; i++) {
                String characters = Character.toString(sample.charAt(i));
                boolean isCorrect = characters.equalsIgnoreCase(Character.toString(ADENINE))
                        || characters.equalsIgnoreCase(Character.toString(THYMINE))
                        || characters.equalsIgnoreCase(Character.toString(CYTOSINE))
                        || characters.equalsIgnoreCase(Character.toString(GUANINE));

                if (!isCorrect) {
                    // throw exception
                }
            }
        }
    }

}
