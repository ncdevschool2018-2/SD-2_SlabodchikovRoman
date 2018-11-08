package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.ScheduleGroup;
import com.netcracker.edu.backend.service.ScheduleGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/schedule_groups")
public class ScheduleGroupController {

    private ScheduleGroupService scheduleGroupService;

    @Autowired
    public ScheduleGroupController(ScheduleGroupService scheduleGroupService) {
        this.scheduleGroupService = scheduleGroupService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<ScheduleGroup> getAllScheduleGroups() {
        return scheduleGroupService.getAllScheduleGroups();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ScheduleGroup> getScheduleGroupById(@PathVariable(name = "id") Long id) {
        Optional<ScheduleGroup> scheduleGroup = scheduleGroupService.getScheduleGroupById(id);
        if (scheduleGroup.isPresent()) {
            return ResponseEntity.ok(scheduleGroup.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteScheduleGroup(@PathVariable(name = "id") Long id) {
        scheduleGroupService.deleteScheduleGroup(id);
        return ResponseEntity.noContent().build();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ScheduleGroup saveScheduleGroup(@RequestBody ScheduleGroup scheduleGroup) {
        return scheduleGroupService.saveScheduleGroup(scheduleGroup);
    }
}
