package com.wor.demo.record.service;

import java.util.ArrayList;

import com.wor.demo.record.dto.RecordDto;
import com.wor.demo.record.dto.RecordDto.RecordResponseDto;

public interface RecordService {
    ArrayList<RecordResponseDto> getRecord(String userId) throws Exception;
    public RecordResponseDto createRecord(RecordDto.Create recordDto) throws Exception;
    public boolean deleteRecord(Long recordId) throws Exception;
}
