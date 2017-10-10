package cn.andy.cloud_note.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.andy.cloud_note.service.NoteService;
import cn.andy.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadNoteController {
	
	@Resource(name="noteService")
	private NoteService noteService;
	
	@ResponseBody
	@RequestMapping("/loadnotes")
	public NoteResult<List<Map>> execute(String bookId){
		NoteResult<List<Map>> result =noteService.loadBookNotes(bookId);
		
		return result;
	}
	@ResponseBody
	@RequestMapping("/load")
	public NoteResult<Map> execute2(String noteId){
		
		NoteResult<Map> result=noteService.loadNote(noteId);
		return result;
	}
}
