package com.hqyj.dao;

import com.hqyj.bean.User;

public interface UserDao {
	public User findByName(String name);
}
