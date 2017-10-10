package cn.andy.cloud_note.service;

import cn.andy.cloud_note.entity.User;
import cn.andy.cloud_note.util.NoteResult;

public interface UserService{
	
	public NoteResult<User> checkLogin(String name,String password);
	public NoteResult<Object> addUser(String name,String password,
			String nick);
}
