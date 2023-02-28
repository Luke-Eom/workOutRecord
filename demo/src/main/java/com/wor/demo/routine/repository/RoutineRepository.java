package com.wor.demo.routine.repository;

import org.springframework.data.repository.CrudRepository;

import com.wor.demo.routine.domain.Routine;

public interface RoutineRepository extends CrudRepository<Routine, Long> {
    
}
