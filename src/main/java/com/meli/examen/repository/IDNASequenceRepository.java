package com.meli.examen.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meli.examen.entity.DNASequence;

/**
 * 
 * @author Rodrigo Cruz <rodriikc@gmail.com>
 */
@Repository
public interface IDNASequenceRepository extends JpaRepository<DNASequence, Long> {

    Optional<DNASequence> findByDna(String dna);

}
