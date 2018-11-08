package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Schedule;

import java.util.Optional;

public interface ScheduleService {
    Optional<Schedule> getScheduleById(Long id);
    Iterable<Schedule> getAllSchedules();
    Schedule saveSchedule(Schedule schedule);
    void deleteSchedule(Long id);
}
