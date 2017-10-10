package test;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.andy.cloud_note.dao.NoteDao;
import cn.andy.cloud_note.entity.Note;

public class TestNoteDao {
	@Test
	public void test1(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		NoteDao dao=ac.getBean("noteDao",NoteDao.class);
		List<Map> book=dao.findByBookId("59b354f8-47ae-437d-a432-7d28736bd894");
				
		System.out.println(book);
	}
	@Test
	public void test2(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		NoteDao dao=ac.getBean("noteDao",NoteDao.class);
		Map book=dao.findByNoteId("3f61785d-c808-4cf9-9009-d2f88e5bbe2f");
				
		System.out.println(book);
	}
	
	@Test
	public void test3(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		NoteDao dao=ac.getBean("noteDao",NoteDao.class);
		Note note=new Note();
		note.setCn_note_id("0ed5aed5-baf0-4f00-9dbf-8da105b16bb2");
		note.setCn_note_title("fuck");
		note.setCn_note_body("fuck the world");
		 dao.updateNote(note);	
	}
	
	@Test
	public void test4(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		NoteDao dao=ac.getBean("noteDao",NoteDao.class);
		Note note=new Note();
		note.setCn_note_id("123456");
		note.setCn_note_title("fuckEverybody");
		note.setCn_note_body("fuck the world all the time");
		 System.out.println(dao.save(note));
	}
	
	@Test
	public void test5(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		NoteDao dao=ac.getBean("noteDao",NoteDao.class);
		int n=dao.delete("01da5d69-89d5-4140-9585-b559a97f9cb0");
		 System.out.println(n);
	}
	
	@Test
	public void test6(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		NoteDao dao=ac.getBean("noteDao",NoteDao.class);
		List<Map> map=dao.findReceiveNote("48595f52-b22c-4485-9244-f4004255b972");
		 System.out.println(map);
	}
	
}
