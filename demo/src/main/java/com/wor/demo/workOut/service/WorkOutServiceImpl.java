package com.wor.demo.workOut.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wor.demo.workOut.domain.WorkOut;
import com.wor.demo.workOut.dto.WorkOutDto;
import com.wor.demo.workOut.mapper.WorkOutMapper;
import com.wor.demo.workOut.repository.WorkOutRepository;

@Service
public class WorkOutServiceImpl implements WorkOutService{
    @Autowired
    WorkOutRepository woRepo;

    @Transactional
    public ArrayList<WorkOutDto> getWorkOutAll() {
        ArrayList<WorkOut> woList = (ArrayList<WorkOut>)woRepo.findAll();
        ArrayList<WorkOutDto> woDtoList = new ArrayList<WorkOutDto>();

        for (WorkOut i : woList){
            woDtoList.add(WorkOutMapper.INSTANCE.woToDto(i));
        }

        return woDtoList;

    }

    public WorkOutDto getWorkOut(Long id) {
        WorkOut wo = woRepo.findById(id).get();
        return WorkOutMapper.INSTANCE.woToDto(wo);

    }

    public ArrayList<WorkOutDto> getWorkOutByBp(){
        ArrayList<WorkOut> woList = (ArrayList<WorkOut>)woRepo.findByBodyPartId();
        ArrayList<WorkOutDto> woDtoList = new ArrayList<WorkOutDto>();

        for (WorkOut i : woList){
            woDtoList.add(WorkOutMapper.INSTANCE.woToDto(i));
        }

        return woDtoList;
    }

    
    // 운동 이름으로 찾기, 신체 부위별 찾기
}
