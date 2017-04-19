package com.test.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.demo.server.UserServer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:WEB-INF/spring-mvc-servlet.xml" })
//@ContextConfiguration(locations = { "classpath*:test-mvc.xml" })
public class UserTest {

	@Test
	public void userInfoTest() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath*:test-mvc.xml");
		UserServer userServer = ac.getBean("userServer", UserServer.class);
		System.out.println(userServer.showUserInfo());
	}

}
