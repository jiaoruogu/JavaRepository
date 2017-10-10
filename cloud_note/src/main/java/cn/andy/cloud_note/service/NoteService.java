package cn.andy.cloud_note.service;

import java.util.List;
import java.util.Map;

import cn.andy.cloud_note.entity.Note;
import cn.andy.cloud_note.util.NoteResult;

public interface NoteService {
	public NoteResult<List<Map>> loadBookNotes(String bookId);
	public NoteResult<Map> loadNote(String noteId);
	public NoteResult updateNote(Note note);
	public NoteResult addNote(String bookId,String noteTitle,String userId);
	public NoteResult deleteNote(String noteId);
	public NoteResult<List<Map>> loadReceiveNote(String userId);
}
