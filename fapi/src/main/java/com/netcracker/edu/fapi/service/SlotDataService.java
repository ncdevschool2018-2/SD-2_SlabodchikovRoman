package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SlotViewModel;

import java.util.List;

public interface SlotDataService {
    SlotViewModel getSlotById(Long id);
    List<SlotViewModel> getAllSlots();
}
