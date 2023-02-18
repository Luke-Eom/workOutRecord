package com.wor.demo;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.wor.demo.user.dto.UserDto;
import com.wor.demo.user.service.UserService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() throws Exception{
		if (applicationContext != null) {
			String[] beans = applicationContext.getBeanDefinitionNames();

			for (String bean : beans) {
				System.out.println("bean: " + bean);
			}
		}
	}
	
	@Test
	public ArrayList<UserDto> userControllerTest() throws Exception{
		ArrayList<UserDto> userAll = userService.getUserAll();

        if (userAll == null){
            System.out.println("회원정보 정보가 없습니다"); // exception handle required
        }
		System.out.println(userAll);
        return userAll;
	}
}
