package com.wor.demo.record.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wor.demo.record.domain.Record;
import com.wor.demo.record.dto.RecordDto;
import com.wor.demo.record.mapper.RecordMapper;
import com.wor.demo.record.repository.Recordrepository;

@Service
public class RecordServiceImpl implements RecordService {
    
    @Autowired
    Recordrepository recordRepo;

    // 개인 기록만 조회 - 추후 회원 아이디에 해당하는 기록만 조회하게끔
    // findAll 후 stream으로 해보기 - 더빠르다고 한다 -> 인덱싱이 되어 있지 않기 때문에 그렇다면 인덱싱을 하거나 b-tree구조 데이터베이스 저장을 한다? 흠.. 생각해보자 
    @Transactional
    public ArrayList<RecordDto> getRecord(String userId) throws Exception {
        ArrayList<Record> records = (ArrayList<Record>)recordRepo.findByUserId(userId);
        ArrayList<RecordDto> recordsDto = new ArrayList<RecordDto>();

        for(Record i:records){
            recordsDto.add(RecordMapper.INSTANCE.recordToEntity(i));
        }

        return recordsDto;
    }

    // 생성 - recordId=autogen, this.userId, now()가 들어가게 dto생성
    // 그 dto를 toEntity로 .save() ---> controller layer
    @Transactional
    public boolean addRecord(RecordDto recordDto) throws Exception {
        boolean result = false;

        if(recordRepo.save(RecordMapper.INSTANCE.recordDtoToEntity(recordDto)) != null) {
            result = true;    
        }

        return result;
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