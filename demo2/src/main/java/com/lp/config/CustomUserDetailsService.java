package com.lp.config;

import com.lp.entity.UserEntity;
import com.lp.model.User;
import com.lp.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService{


	@Autowired(required=false)
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity user = userRepository.findByEmail(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}
}
