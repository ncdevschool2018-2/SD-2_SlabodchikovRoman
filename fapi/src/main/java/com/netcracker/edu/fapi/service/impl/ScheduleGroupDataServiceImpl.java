package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.ScheduleGroupViewModel;
import com.netcracker.edu.fapi.service.ScheduleGroupDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class ScheduleGroupDataServiceImpl implements ScheduleGroupDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public ScheduleGroupViewModel getScheduleGroupById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(backendServerUrl + "/api/schedule_groups/" + id, ScheduleGroupViewModel.class).getBody();
    }

    @Override
    public ScheduleGroupViewModel saveScheduleGroup(ScheduleGroupViewModel scheduleGroup) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/schedule_groups", scheduleGroup, ScheduleGroupViewModel.class).getBody();
    }

    @Override
    public void deleteScheduleGroup(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/schedule_groups/" + id);

    }

    @Override
    public List<ScheduleGroupViewModel> getAllScheduleGroups() {
        RestTemplate restTemplate = new RestTemplate();
        ScheduleGroupViewModel[] scheduleGroups = restTemplate.getForEntity(backendServerUrl + "/api/schedule_groups", ScheduleGroupViewModel[].class).getBody();
        return scheduleGroups == null ? Collections.emptyList() : Arrays.asList(scheduleGroups);
    }
}
