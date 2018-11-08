package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.GroupViewModel;
import com.netcracker.edu.fapi.service.GroupDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class GroupDataServiceImpl implements GroupDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public GroupViewModel saveGroup(GroupViewModel group) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/student_groups", group, GroupViewModel.class).getBody();
    }

    @Override
    public GroupViewModel getGroupById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(backendServerUrl + "/api/student_groups/" + id, GroupViewModel.class).getBody();
    }

    @Override
    public List<GroupViewModel> getAllGroups() {
        RestTemplate restTemplate = new RestTemplate();
        GroupViewModel[] groupViewModels = restTemplate.getForEntity(backendServerUrl + "/api/student_groups", GroupViewModel[].class).getBody();
        return groupViewModels == null ? Collections.emptyList() : Arrays.asList(groupViewModels);
    }



    @Override
    public void deleteGroup(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/student_groups/" + id);
    }
}
