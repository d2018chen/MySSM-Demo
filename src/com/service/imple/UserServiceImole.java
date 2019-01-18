package com.service.imple;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bean.User;
import com.dao.UserDao;
import com.service.UserService;

@Service
@Transactional
public class UserServiceImole implements UserService {
	@Resource
	public UserDao userDao;
	@Override
	public User findByName(String name) {
		User u= userDao.findByName(name);
		return u;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	
	
}
