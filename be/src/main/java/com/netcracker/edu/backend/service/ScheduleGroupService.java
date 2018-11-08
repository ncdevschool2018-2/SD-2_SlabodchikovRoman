package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.ScheduleGroup;

import java.util.Optional;

public interface ScheduleGroupService {
    Optional<ScheduleGroup> getScheduleGroupById(Long id);
    Iterable<ScheduleGroup> getAllScheduleGroups();
    void deleteScheduleGroup(Long id);
    ScheduleGroup saveScheduleGroup(ScheduleGroup scheduleGroup);
}
