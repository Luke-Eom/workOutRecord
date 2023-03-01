package com.wor.demo.record.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wor.demo.record.dto.RecordDto;
import com.wor.demo.record.dto.RecordDto.RecordResponseDto;
import com.wor.demo.record.service.RecordService;

@RestController
@RequestMapping("record")
public class RecordController {
    
    @Autowired
    private RecordService rcService;

    // 조회 : 해당 날짜 기록 조회
    // userId는 세션으로 받아오고, 선택한 date받아와서 record 조회
    @GetMapping("/{userId}/{date}")
    // getRecord with userId and date
    // recordId 바로 front에서 불러올 수 있으면 recordId로

    // 생성 : 
    // userId, date 확인 != null 이면 실행 -> 해당 date에 user의 record가 이미 있는지 없는지 확인
    @PostMapping("/create")   
    public RecordDto.RecordResponseDto create(RecordDto record) throws Exception {
        //if()
        return rcService.createRecord(record);

    }
}