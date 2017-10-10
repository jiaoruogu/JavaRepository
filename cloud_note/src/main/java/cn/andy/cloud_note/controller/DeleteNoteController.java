package cn.andy.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.andy.cloud_note.service.NoteService;
import cn.andy.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {
	
	@Resource(name="noteService")
	private NoteService noteService;
	
	@ResponseBody
	@RequestMapping("/delete")
	public NoteResult execute(String noteId){
		
		NoteResult result=noteService.deleteNote(noteId);
		return result;
	}
}
