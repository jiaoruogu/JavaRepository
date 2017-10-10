package test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.andy.cloud_note.dao.UserDao;
import cn.andy.cloud_note.entity.User;

public class TestUserDao {
	private  UserDao dao;
	@Before
	public void init(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		dao=ac.getBean("userDao",UserDao.class);
	}
	@Test
	public void test1(){
		
		
		User user=dao.findByName("demo");
		System.out.println(user);
	}
	@Test
	public void test2(){
		User user=new User();
		user.setCn_user_id("996");
		user.setCn_user_name("andy");
		user.setCn_user_nick("hero");
		user.setCn_user_password("1234");
		dao.save(user);
	}
}
