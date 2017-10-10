package cn.andy.cloud_note.service;

import java.util.List;

import cn.andy.cloud_note.entity.Book;
import cn.andy.cloud_note.util.NoteResult;

public interface BookService {
	public NoteResult<List<Book>> LoadUserBook(String userId);
	public NoteResult addBook(Book book);
}
