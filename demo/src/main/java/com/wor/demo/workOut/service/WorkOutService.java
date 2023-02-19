package com.wor.demo.workOut.service;

import java.util.ArrayList;

import com.wor.demo.workOut.dto.WorkOutDto;

public interface WorkOutService {
    ArrayList<WorkOutDto> getWorkOutAll() throws Exception;
}
