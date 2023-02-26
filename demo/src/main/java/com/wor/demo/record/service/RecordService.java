package com.wor.demo.record.service;

import java.util.ArrayList;

import com.wor.demo.record.dto.RecordDto;

public interface RecordService {
    ArrayList<RecordDto> getRecord(String userId) throws Exception;
    public boolean addRecord(RecordDto recordDto) throws Exception;
    public boolean deleteRecord(Long recordId) throws Exception;
}
