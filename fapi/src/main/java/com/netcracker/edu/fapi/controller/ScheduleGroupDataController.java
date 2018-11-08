package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.ScheduleGroupViewModel;
import com.netcracker.edu.fapi.service.ScheduleGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba/schedule_groups")
public class ScheduleGroupDataController {
    private ScheduleGroupDataService service;

    @Autowired
    public ScheduleGroupDataController(ScheduleGroupDataService service) {
        this.service = service;
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public ResponseEntity<List<ScheduleGroupViewModel>> getAllScheduleGroups(){
        return ResponseEntity.ok(service.getAllScheduleGroups());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteScheduleGroup(@PathVariable(name="id")String id){
        service.deleteScheduleGroup(Long.valueOf(id));
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<ScheduleGroupViewModel> getScheduleGroupById(@PathVariable(name="id")String id){
        return ResponseEntity.ok(service.getScheduleGroupById(Long.valueOf(id)));
    }

    @RequestMapping(method=RequestMethod.POST)
    public ScheduleGroupViewModel saveScheduleGroup(ScheduleGroupViewModel scheduleGroup){
        return service.saveScheduleGroup(scheduleGroup);
    }
}
