package com.wor.demo.routine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wor.demo.routine.dto.RoutineDto;
import com.wor.demo.routine.repository.RoutineRepository;

@Service
public class RoutineServiceImpl implements RoutineService {
    
    @Autowired
    RoutineRepository rtRepo;


    // 조회 필요 x -> 기록 조회, 생성 수정 삭제
    public RoutineDto addRoutine(RoutineDto rt) throws Exception {
        
        
        return rtRepo.save(rt);

        
    }
}
