package cn.andy.cloud_note.dao;

import java.util.List;
import java.util.Map;

import cn.andy.cloud_note.entity.Note;

public interface NoteDao {
	public List<Map> findByBookId(String bookId);
	public Map findByNoteId(String noteId);
	public int updateNote(Note note);
	public int save(Note note);
	public int delete(String noteId);
	public List<Map> findReceiveNote(String userId);
	
}
