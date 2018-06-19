package com.info.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.info.validatorGroup.ValidatorAdd;
import com.info.validatorGroup.ValidatorEdit;

@SuppressWarnings("serial")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User{
	
	private Integer id;
	
	@NotNull(groups = {ValidatorAdd.class})
	private String account;//登录账号
	@NotNull(groups = {ValidatorAdd.class})
	private String password;//密码（md5加密）
	
	@NotNull(groups = {ValidatorAdd.class, ValidatorEdit.class})
	private String name;
	
	@NotNull(groups = {ValidatorEdit.class})
	private String telphone;
	
	private String email;
	
	private Date createdate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTelphone() {
		return telphone;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

}
