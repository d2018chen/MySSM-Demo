package com.hqyj.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hqyj.bean.User;
import com.hqyj.dao.UserDao;
import com.hqyj.service.UserService;
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	@Override
	public int findByName(User user) {
		int result=0;//用户不存在
		User u=userDao.findByName(user.getUsername());
		if(u!=null){
			result=1;//成功
			if(!user.getPassword().equals(u.getPassword())){
				result=-1;//密码错误
			}
		}
		return result;
	}

}
