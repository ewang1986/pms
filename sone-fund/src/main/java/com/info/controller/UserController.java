package com.info.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.info.model.User;
import com.info.service.UserService;
import com.info.util.Result;
import com.info.util.SimpleField;
import com.info.validatorGroup.ValidatorAdd;

/**
 * 
 * @author v-dongdm
 * @date 2018年5月15日22:13:10
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/login")
	public Result login(@RequestParam("account") String account, 
			@RequestParam("password") String password) {
		return new Result();
	}
	
	/**
	 * 登录用户列表
	 * @return
	 */
	@RequestMapping(value = "/list")
	public List<User> list() { // 通过model可以实现内容的传递
		return this.userService.findAll();
	}
	
	@RequestMapping(value = "/doCreate", method = RequestMethod.POST)
	public Result doCreate(@Validated(ValidatorAdd.class) User user, BindingResult binding) {
		if(binding.hasErrors()) {
			return new Result(HttpStatus.BAD_REQUEST.value(), 
					new SimpleField(binding.getFieldError()));
		}
		this.userService.doCreate(user);
		return new Result("success");
	}
	
	@RequestMapping(value = "/get")
	public String get(@NotNull @RequestParam String id) {
		return "success";
	}
	
	

}
