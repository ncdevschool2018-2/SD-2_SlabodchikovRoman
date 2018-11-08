package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.ProffessorViewModel;
import com.netcracker.edu.fapi.service.ProffessorDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ProffessorDataServiceImpl implements ProffessorDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public ProffessorViewModel getProffessorById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(backendServerUrl + "/api/proffessors/" + id, ProffessorViewModel.class).getBody();
    }

    @Override
    public List<ProffessorViewModel> getAllProffessors() {
        RestTemplate restTemplate = new RestTemplate();
        ProffessorViewModel[] proffessorViewModels = restTemplate.getForObject(backendServerUrl + "/api/proffessors", ProffessorViewModel[].class);
        return proffessorViewModels == null ? Collections.emptyList() : Arrays.asList(proffessorViewModels);
    }

    @Override
    public void deleteProffessor(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/proffessors/" + id);
    }

    @Override
    public ProffessorViewModel saveProffessor(ProffessorViewModel proffessor) {
       RestTemplate restTemplate = new RestTemplate();
       return restTemplate.postForEntity(backendServerUrl+"/api/proffessors",proffessor,ProffessorViewModel.class).getBody();
    }
}
