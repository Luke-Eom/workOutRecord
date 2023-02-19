package com.wor.demo.workOut.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wor.demo.workOut.dto.WorkOutDto;
import com.wor.demo.workOut.service.WorkOutService;

@RestController
@RequestMapping("wo")
public class WorkOutController {
    @Autowired
    private WorkOutService woService;

    @GetMapping("/woAll")
    public ArrayList<WorkOutDto> woAll() throws Exception {
        ArrayList<WorkOutDto> woAll = woService.getWorkOutAll();

        if (woAll == null){
            System.out.println("운동 정보가 없습니다"); // exception handle required
        }
        return woAll;
    }
}
