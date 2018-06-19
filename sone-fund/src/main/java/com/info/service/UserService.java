package com.info.service;

import java.util.List;

import com.info.model.User;

/**
 * 用户
 * @author v-dongdm
 *
 */
public interface UserService {
	
	public List<User> findAll();
	
	public void doCreate(User user);
	
	public User findByAccount(String account);

}
