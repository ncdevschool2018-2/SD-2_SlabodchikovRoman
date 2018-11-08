package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.StudentViewModel;
import com.netcracker.edu.fapi.service.StudentDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StudentDataServiceImpl implements StudentDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public StudentViewModel getStudentById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(backendServerUrl + "/api/students/" + id, StudentViewModel.class).getBody();
    }

    @Override
    public StudentViewModel saveStudent(StudentViewModel student) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/students", student, StudentViewModel.class).getBody();
    }

    @Override
    public void deleteStudent(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/students/" + id);
    }

    @Override
    public List<StudentViewModel> getAllStudents() {
        RestTemplate restTemplate=new RestTemplate();
        StudentViewModel[] studentViewModels=restTemplate.getForEntity(backendServerUrl+"/api/students",StudentViewModel[].class).getBody();
        return studentViewModels==null? Collections.emptyList(): Arrays.asList(studentViewModels);
    }
}
