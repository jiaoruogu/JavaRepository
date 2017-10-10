package cn.andy.cloud_note.dao;

import java.util.List;

import cn.andy.cloud_note.entity.Book;
import cn.andy.cloud_note.entity.Note;

public interface BookDao {
	public List<Book> findByUserId(String userId);
	public int save(Book book); 
}
