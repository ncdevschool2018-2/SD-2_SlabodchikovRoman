package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.SlotViewModel;
import com.netcracker.edu.fapi.service.SlotDataService;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ba/slots")
public class SlotDataController {

    private SlotDataService slotDataService;

    @Autowired
    public SlotDataController(SlotDataService slotDataService) {
        this.slotDataService = slotDataService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<SlotViewModel>> getAllSlots() {
        return ResponseEntity.ok(slotDataService.getAllSlots());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<SlotViewModel> getSlotById(@PathVariable(name = "id") String id) {
        return ResponseEntity.ok(slotDataService.getSlotById(Long.valueOf(id)));
    }

}
