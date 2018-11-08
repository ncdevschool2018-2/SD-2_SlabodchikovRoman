package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.ScheduleViewModel;
import com.netcracker.edu.fapi.service.ScheduleDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
@Service
public class ScheduleDataServiceImpl implements ScheduleDataService {


    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public ScheduleViewModel getScheduleById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(backendServerUrl+"/api/schedules/"+id,ScheduleViewModel.class).getBody();
    }

    @Override
    public List<ScheduleViewModel> getAllSchedules() {
        RestTemplate restTemplate = new RestTemplate();
        ScheduleViewModel[] scheduleViewModels=restTemplate.getForEntity(backendServerUrl+"/api/schedules",ScheduleViewModel[].class).getBody();
        return scheduleViewModels==null? Collections.emptyList(): Arrays.asList(scheduleViewModels);
    }

    @Override
    public ScheduleViewModel saveSchedule(ScheduleViewModel schedule) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl+"/api/schedules", schedule,ScheduleViewModel.class).getBody();
    }

    @Override
    public void deleteSchedule(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl+"/api/schedules/"+id);
    }
}
