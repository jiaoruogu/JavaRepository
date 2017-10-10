package cn.andy.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.andy.cloud_note.entity.Book;
import cn.andy.cloud_note.service.BookService;
import cn.andy.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class LoadBooksController {
	
	@Resource(name="bookService")
	private BookService bookService;
	@RequestMapping("/loadbooks.do")
	@ResponseBody
	public NoteResult<List<Book>> execute(String userId){
		NoteResult<List<Book>> result=bookService.LoadUserBook(userId);
		
		return result;
	}
}
