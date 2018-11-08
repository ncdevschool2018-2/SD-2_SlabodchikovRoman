package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Slot;
import com.netcracker.edu.backend.repository.SlotRepository;
import com.netcracker.edu.backend.service.SlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SlotServiceImpl implements SlotService {
    private SlotRepository repository;

    @Autowired
    public SlotServiceImpl(SlotRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Slot> getSlotById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Slot> getAllSlots() {
        return repository.findAll();
    }
}
