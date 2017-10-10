package cn.andy.cloud_note.controller;

import java.sql.Timestamp;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.andy.cloud_note.entity.Book;
import cn.andy.cloud_note.service.BookService;
import cn.andy.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class AddBookController {
	@Resource(name="bookService")
	private BookService bookService;
	
	@ResponseBody
	@RequestMapping("add")
	public NoteResult execute(String bookTitle,String userId){
		Book book=new Book();
		book.setCn_notebook_name(bookTitle);
		book.setCn_user_id(userId);
		book.setCn_notebook_createtime(new Timestamp(System.currentTimeMillis()));
		
		NoteResult result=bookService.addBook(book);
		
		return result;
	}
}
