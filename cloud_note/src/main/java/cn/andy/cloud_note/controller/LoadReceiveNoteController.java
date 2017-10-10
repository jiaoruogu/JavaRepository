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
@RequestMapping("/load")
public class LoadReceiveNoteController {
	
	@Resource(name="noteService")
	private NoteService noteService;
	
	@ResponseBody
	@RequestMapping("/receive")
	public NoteResult<List<Map>> execute(String userId){
		NoteResult<List<Map>> result=noteService.loadReceiveNote(userId);
		
		return result;
	}
}
