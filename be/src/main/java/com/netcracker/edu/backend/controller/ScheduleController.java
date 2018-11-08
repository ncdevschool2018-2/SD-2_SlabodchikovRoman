package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Schedule;
import com.netcracker.edu.backend.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/schedules")
public class ScheduleController {
    private ScheduleService scheduleService;

    @Autowired
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @RequestMapping(value="", method= RequestMethod.GET)
    public Iterable<Schedule> getAllSchedules(){
        return scheduleService.getAllSchedules();
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<Schedule> getScheduleById(@PathVariable(name="id")Long id){
        Optional<Schedule> schedule = scheduleService.getScheduleById(id);
        if (((Optional) schedule).isPresent()){
            return ResponseEntity.ok(schedule.get());
        } else{
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public void deleteScheduleById(@PathVariable(name="id")Long id){
        scheduleService.deleteSchedule(id);
    }

    @RequestMapping(method=RequestMethod.POST)
    public Schedule saveSchedule(Schedule schedule){
        return scheduleService.saveSchedule(schedule);
    }
}
