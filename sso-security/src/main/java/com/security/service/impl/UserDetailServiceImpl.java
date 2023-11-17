package com.security.service.impl;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.model.User;



@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=this.existeUsuario(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(
                user.getUser(),
                user.getPassword(),
                new ArrayList<>());
	}
	
	private User existeUsuario(String username) {
		User user=null;
		switch (username) {
			case "admin":
				user=new User();
				user.setUser("admin");
				user.setPassword("{noop}adminpass");
				user.setRol("ADMIN");
			break;
			case "Archna":
				user=new User();
				user.setUser("Archna");
				user.setPassword("{noop}archna");
				user.setRol("ADMIN");
			break;
			case "user1":
				user=new User();
				user.setUser("user1");
				user.setPassword("{noop}pass123");
				user.setRol("USER");
			break;
			default:
			break;
		}
		return user;
	}
	
}
