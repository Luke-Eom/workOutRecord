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

    @GetMapping("/userRecord")
    public ArrayList<RecordResponseDto> recordAll(@RequestParam("userId") String userId ) throws Exception {
        ArrayList<RecordResponseDto> recordAll = rcService.getRecord(userId);

        if(recordAll == null){
            throw new Exception();
        }
        return recordAll;
    }

    @PostMapping("/recordInsert")
    public RecordDto.RecordResponseDto create(RecordDto record) throws Exception {

        return rcService.createRecord(record);

    }
}