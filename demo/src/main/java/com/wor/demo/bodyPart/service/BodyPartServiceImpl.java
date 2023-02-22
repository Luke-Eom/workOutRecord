package com.wor.demo.bodyPart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wor.demo.bodyPart.domain.BodyPart;
import com.wor.demo.bodyPart.dto.BodyPartDto;
import com.wor.demo.bodyPart.mapper.BodyPartMapper;
import com.wor.demo.bodyPart.repository.BodyPartRepository;

@Service
public class BodyPartServiceImpl implements BodyPartService {
    
    @Autowired
    BodyPartRepository bpRepo;

    @Transactional
    public BodyPartDto getBpByName(String name) {
        BodyPart bp = bpRepo.findByName(name);
        BodyPartDto bpDto = BodyPartMapper.INSTANCE.bpDtoToEntity(bp);

        return bpDto;
    }

}

// 필요한 기능 - 운동 조회에서 신체 부위별 조회 시 부위 이름을 param으로 받아와 id를 참조해 해당 운동 불러오기
// 전체 조회 시는 필요 x, 신체 부위 이름에 따른 id 참고 필요

//            - db 없는 신체 부위 추가 (v2)  수정? -> 이 경우는 db를 update하는 방식으로 해야될 듯, 기능부분x