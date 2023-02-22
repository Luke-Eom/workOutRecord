package com.wor.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import com.wor.demo.bodyPart.dto.BodyPartDto;
import com.wor.demo.bodyPart.service.BodyPartService;
import com.wor.demo.user.dto.UserDto;
import com.wor.demo.user.service.UserService;
import com.wor.demo.workOut.dto.WorkOutDto;
import com.wor.demo.workOut.service.WorkOutService;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private UserService userService;

	@Autowired
	private WorkOutService woService;

	@Autowired
	private BodyPartService bpService;

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
	public void userControllerTest() throws Exception{
		ArrayList<UserDto> userAll = userService.getUserAll();

        if (userAll == null){
            System.out.println("회원정보 정보가 없습니다"); // exception handle required
        }
		System.out.println(userAll);
	}

	@Test
	public void woControllerTest() throws Exception{
		ArrayList<WorkOutDto> woAll = woService.getWorkOutAll();

        if (woAll == null){
            System.out.println("운동 정보가 없습니다"); // exception handle required
        }
		System.out.println(woAll);

	}

	@Test
	public void bpSearchTest() throws Exception {
		
		String name = "가슴";
		BodyPartDto bp = bpService.getBpByName(name);
		int actual = bp.getId();
		int expected = 1;
	
		assertEquals(expected, actual);
	}
}
