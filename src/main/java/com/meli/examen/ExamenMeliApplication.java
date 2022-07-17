package com.meli.examen;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.meli.examen.service.impl.MutantDetectorServiceImpl;

@SpringBootApplication
public class ExamenMeliApplication {

    public static void main(String[] args) {
//		SpringApplication.run(ExamenMeliApplication.class, args);

        MutantDetectorServiceImpl service = new MutantDetectorServiceImpl();

        String[] dna = { "ATGCGA", "CAGTGC", "TTATGG", "AAAAGG", "CCCGTA", "TCGCTG" };
        System.out.println("1 - " + service.isMutant(dna));

        String[] dna1 = { "TTGCGA", "CAGTGC", "TTATGT", "AGTAGG", "TCCCTA", "TCACTG" };
        System.out.println("2 - " + service.isMutant(dna1));

        String[] dna2 = { "TTGC", "CACT", "TTAT", "AGGT" };
        System.out.println("4 - " + service.isMutant(dna2));

        String[] dna3 = { "TTGCGAT", "CAGTGCT", "TTATGTT", "AGTAGGT", "TCCCTAC", "TCACTGA", "TCACTGA" };
        System.out.println("3 - " + service.isMutant(dna3));
    }

}
