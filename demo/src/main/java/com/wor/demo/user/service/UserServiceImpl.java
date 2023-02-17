package com.wor.demo.user.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wor.demo.user.domain.User;
import com.wor.demo.user.dto.UserDto;
import com.wor.demo.user.mapper.UserMapper;
import com.wor.demo.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepo;

    @Transactional
    public ArrayList<UserDto> getUserAll() {
        ArrayList<User> userList = (ArrayList<User>)userRepo.findAll();
        ArrayList<UserDto> userDtoList = new ArrayList<UserDto>();

        for (User i : userList){
            userDtoList.add(UserMapper.INSTANCE.UserDtoToEntity(i));
        }

        return userDtoList;

    }

    public UserDto getUserByNickname(String nickname){
        User user = userRepo.findByNickname(nickname);
        UserDto userDto = UserMapper.INSTANCE.UserDtoToEntity(user);

        return userDto;

    }

    // 성별 검색 구현

    // 나이대 별 검색
}
