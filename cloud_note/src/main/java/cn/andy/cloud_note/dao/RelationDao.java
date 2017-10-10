package cn.andy.cloud_note.dao;

import cn.andy.cloud_note.entity.User;

public interface RelationDao {
	public User findUserAndBooks(String userId);
	public User findUserAndBooks1(String userId);
}
