package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.DayViewModel;
import com.netcracker.edu.fapi.service.DayDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/ba/days")
public class DayDataController {

    private DayDataService dayDataService;

    @Autowired
    public DayDataController(DayDataService dayDataService) {
        this.dayDataService = dayDataService;
    }

    @RequestMapping(value="",method= RequestMethod.GET)
    public ResponseEntity<List<DayViewModel>> getAllDays(){
        return ResponseEntity.ok(dayDataService.getAllDays());
    }

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    public ResponseEntity<DayViewModel> getDayById(@PathVariable(name="id")String id){
        return ResponseEntity.ok((dayDataService.getDayById(Long.valueOf(id))));
    }
}
