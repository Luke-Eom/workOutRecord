package com.wor.demo.workOut.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.wor.demo.workOut.domain.WorkOut;

public interface WorkOutRepository extends CrudRepository<WorkOut, Long> {

    ArrayList<WorkOut> findByBodyPartId();
    
    
}
