package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SlotViewModel;
import com.netcracker.edu.fapi.service.SlotDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SlotDataServiceImpl implements SlotDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;


    @Override
    public SlotViewModel getSlotById(Long id) {
        RestTemplate restTemplate=new RestTemplate();
        return restTemplate.getForObject(backendServerUrl+"api/slots/"+id,SlotViewModel.class);
    }

    @Override
    public List<SlotViewModel> getAllSlots() {
        RestTemplate restTemplate=new RestTemplate();
        SlotViewModel[] slotViewModelResponse=restTemplate.getForObject(backendServerUrl+"api/slots", SlotViewModel[].class);
        return slotViewModelResponse == null? Collections.emptyList(): Arrays.asList(slotViewModelResponse);
    }
}
