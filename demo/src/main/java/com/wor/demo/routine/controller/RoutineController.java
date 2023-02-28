package com.wor.demo.routine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wor.demo.routine.service.RoutineService;

@RestController
@RequestMapping("rt")
public class RoutineController {
    @Autowired
    private RoutineService rService;

    
}
