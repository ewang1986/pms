package com.info.service.impl;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.UserDao;
import com.info.model.User;
import com.info.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	public List<User> findAll() {
		return userDao.findAll();
	}

	public void doCreate(User user) {
		userDao.doCreate(user);
	}
	
	public User findByAccount(String account) {
		if(StringUtils.isBlank(account)) return null;
		User user = new User();
		user.setAccount(account);
		return userDao.findByAccount(user);
	}

}
