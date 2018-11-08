package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Proffessor;

import java.util.Optional;

public interface ProffessorService {
    Proffessor saveProffessor(Proffessor proffessor);
    Iterable<Proffessor> getAllProffessors();
    Optional<Proffessor> getProffessorByID(Long id);
    void deleteProffessor(Long id);

}
