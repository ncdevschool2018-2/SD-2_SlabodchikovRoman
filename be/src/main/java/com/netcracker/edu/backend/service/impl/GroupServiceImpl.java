package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Group;
import com.netcracker.edu.backend.repository.GroupRepository;
import com.netcracker.edu.backend.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GroupServiceImpl implements GroupService {
    private GroupRepository groupRepository;

    @Autowired
    public GroupServiceImpl(GroupRepository repository) {
        this.groupRepository = repository;
    }

    @Override
    public Group saveGroup(Group group) {
        return groupRepository.save(group);
    }

    @Override
    public Optional<Group> getGroupById(Long id) {
        return groupRepository.findById(id);
    }

    @Override
    public Iterable<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    @Override
    public void deleteGroup(Long id) {
        groupRepository.deleteById(id);
    }
}
