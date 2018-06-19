package com.info.config;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.info.model.User;
import com.info.service.UserService;

/**
 * spring security 验证用户登录
 * @author v-dongdm
 * 2018年5月21日00:04:55
 */
@Component("userDetailsService")
public class DbUserDetailsService implements AuthenticationProvider{

	protected static Logger logger = LoggerFactory.getLogger(DbUserDetailsService.class);

	@Autowired
	private UserService userService;


	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// 获取认证的用户名 & 密码
        String account = authentication.getName();
        String password = authentication.getCredentials().toString();
		User user = userService.findByAccount(account);
		//账号不存在
		if(null == user) throw new UsernameNotFoundException("");
		//密码不正确
		if(!password.equals(user.getPassword())) throw new BadCredentialsException("");
		// 获取用户的所有权限并且SpringSecurity需要的集合
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
		grantedAuthorities.add(grantedAuthority);
		// 返回一个SpringSecurity需要的用户对象
		// 这里设置权限和角色
        ArrayList<GrantedAuthority> authorities = new ArrayList<>();
        // 生成令牌
        Authentication auth = new UsernamePasswordAuthenticationToken(user.getAccount(),
        		user.getPassword(), authorities);
        return auth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}
}
