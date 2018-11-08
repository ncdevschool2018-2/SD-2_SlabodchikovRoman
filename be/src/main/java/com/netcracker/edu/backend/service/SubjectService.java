package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Subject;

import java.util.Optional;

public interface SubjectService {
    Optional<Subject> getSubjectById(Long id);
    Iterable<Subject> getAllSubjects();
    void deleteSubject(Long id);
    Subject saveSubject(Subject subject);
}
