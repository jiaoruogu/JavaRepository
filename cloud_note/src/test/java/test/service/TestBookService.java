package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.andy.cloud_note.entity.Book;
import cn.andy.cloud_note.service.BookService;
import cn.andy.cloud_note.util.NoteResult;

public class TestBookService {
	private BookService service;
	@Before
	public void init(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		service=ac.getBean("bookService",BookService.class);
	}
	@Test
	public void test1(){
		String userId="48595f52-b22c-4485-9244-f4004255b972";
		NoteResult<List<Book>> result=service.LoadUserBook(userId);
		System.out.println(result.getStatus());
		System.out.println(result.getData());
		
	}
}
