package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Proffessor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProffessorRepository extends CrudRepository<Proffessor, Long> {
}
