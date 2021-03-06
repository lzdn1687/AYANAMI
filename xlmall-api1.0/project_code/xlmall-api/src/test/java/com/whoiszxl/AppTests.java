package com.whoiszxl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.whoiszxl.dao.UserMapper;
import com.whoiszxl.entity.User;
import com.whoiszxl.repo.primary.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTests {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void jpaTest() {
		List<User> findAll = userRepository.findAll();
		System.out.println(findAll);
	}
	
	
	@Test
	public void mybatisTest() {
		User selectByPrimaryKey = userMapper.selectByPrimaryKey(1);
		System.out.println(selectByPrimaryKey);
	}
	

}
