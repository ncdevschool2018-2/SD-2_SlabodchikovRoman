package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Student;

import java.util.Optional;

public interface StudentService {
    Optional<Student> getStudentById(Long id);
    Iterable<Student> getAllStudents();
    Student saveStudent(Student student);
    void deleteStudent(Long id);
}
