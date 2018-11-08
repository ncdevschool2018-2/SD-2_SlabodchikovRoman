package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.Slot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends CrudRepository<Slot, Long> {
}
