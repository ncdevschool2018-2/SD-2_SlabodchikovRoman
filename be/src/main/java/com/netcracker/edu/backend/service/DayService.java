package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Day;

import java.util.Optional;

public interface DayService   {
    Optional<Day> getDayByID(Long id);
    Iterable<Day> getAllDays();
}
