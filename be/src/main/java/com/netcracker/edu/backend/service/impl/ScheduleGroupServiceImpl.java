package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.ScheduleGroup;
import com.netcracker.edu.backend.repository.ScheduleGroupRepository;
import com.netcracker.edu.backend.service.ScheduleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ScheduleGroupServiceImpl implements ScheduleGroupService {

    private ScheduleGroupRepository repository;


    @Autowired
    public ScheduleGroupServiceImpl(ScheduleGroupRepository repository) {
        this.repository = repository;
    }


    @Override
    public Optional<ScheduleGroup> getScheduleGroupById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<ScheduleGroup> getAllScheduleGroups() {
        return repository.findAll();
    }

    @Override
    public void deleteScheduleGroup(Long id) {
        repository.deleteById(id);
    }

    @Override
    public ScheduleGroup saveScheduleGroup(ScheduleGroup scheduleGroup) {
        return repository.save(scheduleGroup);
    }
}
