package com.netcracker.edu.backend.repository;

import com.netcracker.edu.backend.entity.ScheduleGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleGroupRepository extends CrudRepository<ScheduleGroup, Long> {
}
