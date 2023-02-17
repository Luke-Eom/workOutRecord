package com.wor.demo.user.service;

import java.util.ArrayList;

import com.wor.demo.user.dto.UserDto;

public interface UserService {
    ArrayList<UserDto> getUserAll() throws Exception;
    UserDto getUserByNickname(String nickname) throws Exception;
}
