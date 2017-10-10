package test.service;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.andy.cloud_note.entity.Note;
import cn.andy.cloud_note.service.NoteService;
import cn.andy.cloud_note.util.NoteResult;

public class TestNoteService {
	private NoteService service;
	@Before
	public void init(){
		ApplicationContext ac=new 
				ClassPathXmlApplicationContext("conf/spring-*.xml");
		service=ac.getBean("noteService",NoteService.class);
	}
	@Test
	public void test1(){
		String bookId="59b354f8-47ae-437d-a432-7d28736bd894";
		NoteResult<List<Map>> result=service.loadBookNotes(bookId);
		System.out.println(result.getStatus());
		System.out.println(result.getData().get(0).get("cn_note_title"));
		
	}
	@Test
	public void test2(){
		String noteId="3f61785d-c808-4cf9-9009-d2f88e5bbe2f";
		NoteResult<Map> result=service.loadNote(noteId);
		System.out.println(result.getStatus());
		System.out.println(result.getData());
		
	}
	@Test
	public void test3(){
		Note note=new Note();
		note.setCn_note_id("0ed5aed5-baf0-4f00-9dbf-8da105b16bb2");
		note.setCn_note_title("fuckAll");
		note.setCn_note_body("fuck the world");
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		NoteResult<Map> result=service.updateNote(note);
		System.out.println(result.getStatus());
		System.out.println(result.getData());
		
	}
	
	@Test
	public void test4(){
		
		NoteResult result=service.addNote("852741", "³´·¹", "UUID");
		System.out.println(result.getStatus());
		System.out.println(result.getData());
		
	}
	
	@Test
	public void test5(){
		
		NoteResult result=service.deleteNote("046b0110-67f9-48c3-bef3-b0b23bda9d4e");
		System.out.println(result.getStatus());
		System.out.println(result.getData());
		
	}
	
	@Test
	public void test6(){
		
		NoteResult result=service.loadReceiveNote("48595f52-b22c-4485-9244-f4004255b972");
		System.out.println(result.getStatus());
		System.out.println(result.getData());
		
	}
	
}
