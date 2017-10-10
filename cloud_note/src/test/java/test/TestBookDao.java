package test;

import java.sql.Timestamp;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.andy.cloud_note.dao.BookDao;
import cn.andy.cloud_note.entity.Book;

public class TestBookDao {
	@Test
	public void test1(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		BookDao dao=ac.getBean("bookDao",BookDao.class);
		List<Book> book=dao.findByUserId("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println(book);
	}
	@Test
	public void test2(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		BookDao dao=ac.getBean("bookDao",BookDao.class);
		
		Book book=new Book();
		book.setCn_user_id("123");
		book.setCn_notebook_id("123");
		book.setCn_notebook_name("²ÙÄãÂè");
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		System.out.println(book.toString());
		int n=dao.save(book);
		System.out.println(n);
	}
}
