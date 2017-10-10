package cn.andy.cloud_note.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.andy.cloud_note.entity.Note;
import cn.andy.cloud_note.service.NoteService;
import cn.andy.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class UpdateNoteController {
	@Resource(name="noteService")
	private NoteService noteService;
	
	@ResponseBody
	@RequestMapping("/update")
	public NoteResult execute(String noteId,
			String noteTitle,String noteBody){
		Note note=new Note();
		note.setCn_note_body(noteBody);
		note.setCn_note_id(noteId);
		note.setCn_note_title(noteTitle);
		note.setCn_note_last_modify_time(System.currentTimeMillis());
		NoteResult result=noteService.updateNote(note);
		return result;
	}
}
