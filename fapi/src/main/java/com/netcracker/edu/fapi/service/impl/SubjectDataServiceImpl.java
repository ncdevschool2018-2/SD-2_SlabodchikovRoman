package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SubjectViewModel;
import com.netcracker.edu.fapi.service.SubjectDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.security.auth.Subject;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubjectDataServiceImpl implements SubjectDataService {


    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public SubjectViewModel saveSubject(SubjectViewModel subject) {
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl+"/api/subjects", subject, SubjectViewModel.class).getBody();
    }

    @Override
    public SubjectViewModel getSubjectById(Long id) {
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"/api/subjects/" +id,SubjectViewModel.class);
    }

    @Override
    public List<SubjectViewModel> getAllSubjects() {
        RestTemplate restTemplate=new RestTemplate();
        SubjectViewModel[] subjectViewModels=restTemplate.getForEntity(backendServerUrl+"/api/subjects",SubjectViewModel[].class).getBody();
        return subjectViewModels==null? Collections.emptyList(): Arrays.asList(subjectViewModels);
    }

    @Override
    public void deleteSubject(Long id) {
        RestTemplate restTemplate=new RestTemplate();
        restTemplate.delete(backendServerUrl+"api/subjects/"+id);
    }
}
