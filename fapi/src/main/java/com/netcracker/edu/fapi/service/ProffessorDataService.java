package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.ProffessorViewModel;
import org.springframework.stereotype.Service;

import java.util.List;
public interface ProffessorDataService {
    ProffessorViewModel getProffessorById(Long id);
    List<ProffessorViewModel> getAllProffessors();
    void deleteProffessor(Long id);
    ProffessorViewModel saveProffessor(ProffessorViewModel proffessor);
}
