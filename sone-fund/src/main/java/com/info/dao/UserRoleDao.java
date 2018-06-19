package com.info.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.info.model.UserRole;

/**
 * 用户角色配置
 * @author v-dongdm
 *
 */
@Mapper
public interface UserRoleDao {
	
	public List<UserRole> findAll();
	
	public void doCreate(UserRole userRole);
	
}
