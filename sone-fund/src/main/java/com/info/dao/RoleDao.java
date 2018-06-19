package com.info.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.info.model.Role;

/**
 * 角色
 * @author v-dongdm
 *
 */
@Mapper
public interface RoleDao {
	
	public List<Role> findAll();
	
	public void doCreate(Role role);
	

}
