package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Proffessor;
import com.netcracker.edu.backend.repository.ProffessorRepository;
import com.netcracker.edu.backend.service.ProffessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProffessorServiceImpl implements ProffessorService {

    private ProffessorRepository repository;

    @Autowired
    public ProffessorServiceImpl(ProffessorRepository repository) {
        this.repository = repository;
    }

    @Override
    public Proffessor saveProffessor(Proffessor proffessor) {
        return repository.save(proffessor);
    }

    @Override
    public Iterable<Proffessor> getAllProffessors() {
        return repository.findAll();
    }

    @Override
    public Optional<Proffessor> getProffessorByID(Long id) {
        return repository.findById(id);
    }

    @Override
    public void deleteProffessor(Long id) {
        repository.deleteById(id);
    }
}
