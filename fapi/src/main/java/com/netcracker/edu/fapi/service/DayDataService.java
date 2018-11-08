package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.DayViewModel;

import java.util.List;

public interface DayDataService {
    DayViewModel getDayById(Long id);
    List<DayViewModel> getAllDays();
}
