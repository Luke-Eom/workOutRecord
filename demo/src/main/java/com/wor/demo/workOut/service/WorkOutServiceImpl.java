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
            woDtoList.add(WorkOutMapper.INSTANCE.woDtoToEntity(i));
        }

        return woDtoList;

    }
    
    // 운동 이름으로 찾기, 신체 부위별 찾기, 기구여부 찾기 (기구여부, 신체부위별 중복 옵션 로직 짜기)
}
