package cn.andy.cloud_note.service;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.andy.cloud_note.dao.BookDao;
import cn.andy.cloud_note.entity.Book;
import cn.andy.cloud_note.util.NoteResult;

@Service("bookService")
public class BookServiceImpl implements BookService{
	
	@Resource(name="bookDao")
	private BookDao bookDao;
	public NoteResult<List<Book>> LoadUserBook(String userId) {
		NoteResult<List<Book>> result=new NoteResult<List<Book>>();
		List<Book> books=bookDao.findByUserId(userId);
		
		
		
		
		if(books.size()<0){
			result.setMsg("暂时没有创建笔记！");
			result.setStatus(1);
			return result;
		}
		result.setData(books);
		result.setMsg("创建笔记本成功！");
		result.setStatus(0);
		return result;
	}
	public NoteResult addBook(Book book) {
		NoteResult result=new NoteResult();
		UUID uuid=UUID.randomUUID();
		book.setCn_notebook_id(uuid.toString());
		int n=bookDao.save(book);
		if(n==1){
			result.setMsg("创建笔记成功！");
			result.setStatus(0);
			result.setData(uuid);
			return result;
		}
		result.setMsg("创建笔记失败！");
		result.setStatus(1);
		
		return result;
	}

}
