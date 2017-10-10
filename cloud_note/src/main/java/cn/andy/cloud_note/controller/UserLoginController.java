package cn.andy.cloud_note.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.andy.cloud_note.entity.User;
import cn.andy.cloud_note.service.UserService;
import cn.andy.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")//∆•≈‰«Î«Û¬∑æ∂
public class UserLoginController {
	
	@Resource(name="userService")
	private UserService userService;
	@ResponseBody//json ‰≥ˆ
	@RequestMapping("/login.do")
	public NoteResult<User> execute(String name,String password) throws Exception{
		
		NoteResult<User> result=userService.checkLogin(name,password );
		return result;
	}
}
