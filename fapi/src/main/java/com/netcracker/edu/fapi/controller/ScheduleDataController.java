package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.ScheduleViewModel;
import com.netcracker.edu.fapi.service.ScheduleDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba/schedules")
public class ScheduleDataController {
    private ScheduleDataService service;

    @Autowired
    public ScheduleDataController(ScheduleDataService service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ScheduleViewModel>> getAllSchedules() {
        return ResponseEntity.ok(service.getAllSchedules());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteSchedule(@PathVariable(name = "id") String id) {
        service.deleteSchedule(Long.valueOf(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ScheduleViewModel> getScheduleById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(service.getScheduleById(Long.valueOf(id)));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ScheduleViewModel saveSchedule(ScheduleViewModel schedule) {
        return service.saveSchedule(schedule);
    }
}
