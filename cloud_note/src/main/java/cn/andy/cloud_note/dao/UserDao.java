package cn.andy.cloud_note.dao;

import cn.andy.cloud_note.entity.User;

public interface UserDao {
	public User findByName(String name);
	public void save(User user);
}
