package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SubjectViewModel;

import java.util.List;

public interface SubjectDataService {
    SubjectViewModel saveSubject(SubjectViewModel subject);
    SubjectViewModel getSubjectById(Long id);
    List<SubjectViewModel> getAllSubjects();
    void deleteSubject(Long id);
}
