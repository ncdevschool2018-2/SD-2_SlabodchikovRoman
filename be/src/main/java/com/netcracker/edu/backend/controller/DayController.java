package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Day;
import com.netcracker.edu.backend.service.DayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/days")
public class DayController {
    private DayService dayService;

    @Autowired

    public DayController(DayService dayService) {
        this.dayService = dayService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Day> getAllDays(){
        return dayService.getAllDays();
    }

    @RequestMapping(value="{id}", method=RequestMethod.GET)
    public Optional<Day> getDayById(@PathVariable(name="id")Long id){
        return dayService.getDayByID(id);
    }
}
