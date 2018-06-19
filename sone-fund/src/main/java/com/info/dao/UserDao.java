package com.info.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.info.model.User;

/**
 * 用户
 * @author v-dongdm
 *
 */
@Mapper
public interface UserDao {
	
	public List<User> findAll();
	
	public void doCreate(User user);
	
	public User findByAccount(User user);

}
