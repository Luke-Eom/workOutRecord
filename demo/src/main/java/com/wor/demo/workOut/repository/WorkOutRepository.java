package com.wor.demo.workOut.repository;

import org.springframework.data.repository.CrudRepository;

import com.wor.demo.workOut.domain.WorkOut;

public interface WorkOutRepository extends CrudRepository<WorkOut, Long> {
    
    
}
