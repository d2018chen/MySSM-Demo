package com.dao;

import com.bean.User;

public interface UserDao {
	public User findByName(String name);
}
