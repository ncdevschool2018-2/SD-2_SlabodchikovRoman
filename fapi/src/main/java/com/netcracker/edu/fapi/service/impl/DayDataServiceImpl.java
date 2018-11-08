package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.DayViewModel;
import com.netcracker.edu.fapi.service.DayDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DayDataServiceImpl implements DayDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public DayViewModel getDayById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(backendServerUrl + "api/days/" + id, DayViewModel.class).getBody();
    }

    @Override
    public List<DayViewModel> getAllDays() {
        RestTemplate restTemplate = new RestTemplate();
        DayViewModel[] dayViewModels = restTemplate.getForObject(
                backendServerUrl + "/api/days",
                DayViewModel[].class);
        return dayViewModels == null ? Collections.emptyList() : Arrays.asList(dayViewModels);
    }
}
