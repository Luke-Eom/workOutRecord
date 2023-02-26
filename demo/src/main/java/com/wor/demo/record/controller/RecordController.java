package com.wor.demo.record.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wor.demo.record.dto.RecordDto;
import com.wor.demo.record.service.RecordService;

@RestController
@RequestMapping("record")
public class RecordController {
    
    @Autowired
    private RecordService rcService;

    @GetMapping("/userRecord")
    public ArrayList<RecordDto> recordAll(@RequestParam("userId") String userId ) throws Exception {
        ArrayList<RecordDto> recordAll = rcService.getRecord(userId);

        if(recordAll == null){
            throw new Exception();
        }
        return recordAll;
    }

    @PostMapping("/recordInsert")
    public boolean recordInsert(RecordDto record) throws Exception {

        boolean result = rcService.addRecord(record);
        return result;

    }
}