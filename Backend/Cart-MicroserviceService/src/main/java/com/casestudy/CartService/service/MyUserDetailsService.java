//package com.casestudy.CartService.service;
//
//import java.util.ArrayList;
//
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.casestudy.CartService.entity.User1;
//import com.casestudy.CartService.repository.UserRepository;
//
//
//
//@Service
//public class MyUserDetailsService implements UserDetailsService {
//	
//	Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
//
//	@Autowired
//	UserRepository repo;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		logger.info("Built in abstract method of userdetailsservice interface to load the username and password");
//		User1 user = repo.findByUsername(username);
//		if (user == null) {
//			return null;
//		}
//		String name = user.getUsername();
//		String pwd = user.getPassword();
//
//		return new User(name, pwd, new ArrayList<>());
//
//	}
//
//}
