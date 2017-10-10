package cn.andy.cloud_note.service;



import java.security.NoSuchAlgorithmException;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.andy.cloud_note.dao.UserDao;
import cn.andy.cloud_note.entity.User;
import cn.andy.cloud_note.util.NoteResult;
import cn.andy.cloud_note.util.NoteUtil;

@Service("userService")//扫描Spring容器
@Transactional
public class UserServiceImpl implements UserService {
	
	@Resource(name="userDao")
	private UserDao userDao;
	public NoteResult<User> checkLogin(String name, String password)  {
		//接收结果数据
		NoteResult <User> result=new NoteResult<User>();
		User user=userDao.findByName(name);
		if(user==null){
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		//将用户输入的密码加密
		String md5_pwd=NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5_pwd)){
			result.setStatus(2);
			result.setMsg("密码不正确！");
			return result;
		}
		//
		result.setStatus(0);
		result.setMsg("登录成功！");
		result.setData(user);
		return result;
	}
	
	public NoteResult<Object> addUser(String name, String password, String nick) {
		NoteResult<Object> result=new NoteResult<Object>();
		User user=userDao.findByName(name);
		if(user!=null){
			result.setMsg("该用户被占用");
			result.setStatus(1);
			return result;
		}
		User newUser=new User();
		newUser.setCn_user_name(name);
		newUser.setCn_user_nick(nick);
		newUser.setCn_user_id(NoteUtil.createId());
		newUser.setCn_user_password(NoteUtil.md5(password));
		userDao.save(newUser);
		result.setMsg("注册成功");
		result.setStatus(0);
		return result;
		
	}

}
