package com.netcracker.edu.backend.controller;


import com.netcracker.edu.backend.entity.Slot;
import com.netcracker.edu.backend.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/slots")
public class SlotController {
    private SlotService slotService;

    @Autowired
    public SlotController(SlotService slotService) {
        this.slotService = slotService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Slot> getAllSlots() {
        return slotService.getAllSlots();
    }

    @RequestMapping(value="{id}" ,method = RequestMethod.GET)
    public Optional<Slot> getSlotById(@PathVariable(name="id")Long id){
        return slotService.getSlotById(id);
    }
}
