package com.wor.demo.record.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wor.demo.record.domain.Record;
import com.wor.demo.record.dto.RecordDto;
import com.wor.demo.record.dto.RecordDto.RecordResponseDto;
import com.wor.demo.record.repository.Recordrepository;
import com.wor.demo.user.domain.User;
import com.wor.demo.user.repository.UserRepository;

@Service
public class RecordServiceImpl implements RecordService {
    
    @Autowired
    Recordrepository recordRepo;

    @Autowired
    UserRepository userRepo;

    // 개인 기록만 조회 - 추후 회원 아이디에 해당하는 기록만 조회하게끔
    // findAll 후 stream으로 해보기 - 더빠르다고 한다 -> 인덱싱이 되어 있지 않기 때문에 그렇다면 인덱싱을 하거나 b-tree구조 데이터베이스 저장을 한다? 흠.. 생각해보자 
    @Transactional
    public ArrayList<RecordResponseDto> getRecord(String userId) throws Exception {
        ArrayList<Record> records = (ArrayList<Record>)recordRepo.findByUserId(userId);
        ArrayList<RecordResponseDto> recordsDto = new ArrayList<RecordResponseDto>();

        for(Record i:records){
            recordsDto.add(RecordDto.toResponseDto(i));
        }

        return recordsDto;
    }

    // 생성
    // 받아온 param으로 entity에 저장
    // 그 dto를 toEntity로 .save() ---> controller layer
    @Transactional
    public RecordResponseDto createRecord(RecordDto.Create createDto) throws Exception {
        User user = userRepo.findById(createDto.getUserId()).get();
        Record record = new Record(createDto.getDate());
        record.setUser(user);
        recordRepo.save(record);
        // routineService save
        return RecordDto.toResponseDto(record);

    }

    // 수정은 따로 필요없을듯
    // @Transactional
    // public boolean updateRecord() throws Exception {

    // }

    //controller layer에서 해당 userId가 그 날 now()에 기록이 있을때만 이버튼 보이게
    @Transactional
    public boolean deleteRecord(Long recordId) throws Exception {
        boolean result = false;

        Record record = recordRepo.findRecordById(recordId);

        if (record == null) {
            result = false; // exception 처리 throw new NotExistException("msg");
        } else {
            recordRepo.delete(record);

            if (recordRepo.findRecordById(recordId) == null){
                result = true;
            }
        }
        return result;

    }
}
    
        
//조회,생성, 수정, 삭제