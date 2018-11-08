package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Schedule;
import com.netcracker.edu.backend.repository.ScheduleRepository;
import com.netcracker.edu.backend.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ScheduleServiceImpl implements ScheduleService {

    private ScheduleRepository repository;

    @Autowired
    public ScheduleServiceImpl(ScheduleRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Schedule> getScheduleById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Schedule> getAllSchedules() {
        return repository.findAll();
    }

    @Override
    public Schedule saveSchedule(Schedule schedule) {
        return repository.save(schedule);
    }

    @Override
    public void deleteSchedule(Long id) {
        repository.deleteById(id);
    }
}
