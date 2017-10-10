package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.andy.cloud_note.entity.User;
import cn.andy.cloud_note.service.UserService;
import cn.andy.cloud_note.util.NoteResult;

public class TestUserService {
	private UserService service;
	@Before
	public void init(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		service=ac.getBean("userService",UserService.class);
	}
	@Test
	public void test1() throws Exception{
		NoteResult<User> result=service.checkLogin("haha", "123");
		System.out.println(service.getClass().getName());
		
	}
	@Test
	public void test2() throws Exception{
		NoteResult<User> result=service.checkLogin("demo", "123");
		System.out.println(result.getMsg());
		System.out.println(result.getData());
		System.out.println(result.getStatus());
	}
	@Test
	public void test3() throws Exception{
		NoteResult<User> result=service.checkLogin("demo", "1234");
		System.out.println(result.getMsg());
		System.out.println(result.getData());
		System.out.println(result.getStatus());
	}
	@Test
	public void test4(){
		service.addUser("Ви", "1234", "Ш§Ви");
	}
}
	