package com.wor.demo.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private int id;
    private String email;
    private String password;
    private String nickname;
    private String gender;
    private int age;
}
