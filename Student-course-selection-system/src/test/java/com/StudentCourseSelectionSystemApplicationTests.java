package com;

import com.domain.Menu;
import com.domain.User;
import com.mapper.MenuMapper;
import com.mapper.UserMapper;
import com.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@SpringBootTest
class StudentCourseSelectionSystemApplicationTests {
	@Autowired
	private LoginService loginService;
    @Autowired
	private UserMapper userMapper;
	@Autowired
	private MenuMapper menuMapper;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Test
	void contextLoads() {
	}
    @Test
	void test(){
		List<User> student=userMapper.selectList(null);
		System.out.println(student);
	}
	@Test
	void test1(){
		User student=userMapper.selectById(2);
		System.out.println(student);
//		System.out.println(student.getPassword());
		System.out.println(passwordEncoder.matches("1234",student.getPassword()));;
	}
	@Test
	void test2(){
		System.out.println(menuMapper.selectPermsByUserId(2L));
	}
}
