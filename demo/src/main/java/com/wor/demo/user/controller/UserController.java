package com.wor.demo.user.controller;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.wor.demo.user.domain.User;
import com.wor.demo.user.dto.UserDto;
import com.wor.demo.user.service.JwtService;
import com.wor.demo.user.service.UserService;

@RestController
@RequestMapping("u")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private JwtService jwtService;

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

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody Map<String, String> params, HttpServletResponse res) {
        // * member service로 바꾸고 카톡 연동 적용하기
        User user = userService.findByEmailAndPassword(params.get("email"), params.get("password"));
        if (user != null) {
            int id = user.getId();
            String token = jwtService.getToken("id", id);

            Cookie cookie = new Cookie("token",token);
            cookie.setHttpOnly(true);
            cookie.setPath("/");

            res.addCookie(cookie);

            return new ResponseEntity<>(id, HttpStatus.OK);
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND);

    }
    
    //JWT 토큰
    @GetMapping("/check")
    public ResponseEntity check(@CookieValue(value = "token", required = false) String token) {
        Claims claims = jwtService.getClaims(token);

        if (claims != null) {
            int id = Integer.parseInt(claims.get("id").toString());

            return new ResponseEntity<>(id, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

}
