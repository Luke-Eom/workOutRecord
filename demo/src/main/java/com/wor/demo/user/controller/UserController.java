package com.wor.demo.user.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wor.demo.user.dto.UserDto;
import com.wor.demo.user.service.UserService;

@RestController
@RequestMapping("userRest")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/userAll")
    public ArrayList<UserDto> userAll() throws Exception {
        ArrayList<UserDto> userAll = userService.getUserAll();

        if (userAll == null){
            System.out.println("회원정보 정보가 없습니다"); // exception handle required
        }
        return userAll;
    }

    @GetMapping("/userByNickname")
    public UserDto userByNickname(@RequestParam("nickname") String nickname) throws Exception {
        if(userService.getUserByNickname(nickname) == null){
            System.out.println("찾으시는 회원정보 정보가 없습니다"); // exception handle required
        }
        return userService.getUserByNickname(nickname);
    }
}
