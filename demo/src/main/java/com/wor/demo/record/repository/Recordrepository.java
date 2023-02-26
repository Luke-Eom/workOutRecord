package com.wor.demo.record.repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.wor.demo.record.domain.Record;

public interface Recordrepository extends CrudRepository<Record, Long> {

    ArrayList<Record> findByUserId(String userId);

    Record findRecordById(Long recordId);

    
}
