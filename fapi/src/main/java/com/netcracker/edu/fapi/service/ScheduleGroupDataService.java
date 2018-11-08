package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.ScheduleGroupViewModel;

import java.util.List;

public interface ScheduleGroupDataService {
    ScheduleGroupViewModel getScheduleGroupById(Long id);
    ScheduleGroupViewModel saveScheduleGroup(ScheduleGroupViewModel scheduleGroup);
    void deleteScheduleGroup(Long id);
    List<ScheduleGroupViewModel> getAllScheduleGroups();
}
