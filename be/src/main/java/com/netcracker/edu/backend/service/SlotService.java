package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Slot;

import java.util.Optional;

public interface SlotService {
    Optional<Slot> getSlotById(Long id);
    Iterable<Slot> getAllSlots();
}
