package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.ScheduleViewModel;

import java.util.List;

public interface ScheduleDataService {
    ScheduleViewModel getScheduleById(Long id);
    List<ScheduleViewModel> getAllSchedules();
    ScheduleViewModel saveSchedule(ScheduleViewModel schedule);
    void deleteSchedule(Long id);
}
