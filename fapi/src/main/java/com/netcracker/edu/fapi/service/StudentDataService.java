package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.StudentViewModel;

import java.util.List;

public interface StudentDataService {
    StudentViewModel getStudentById(Long id);
    StudentViewModel saveStudent(StudentViewModel student);
    void deleteStudent(Long id);
    List<StudentViewModel> getAllStudents();
}
