package com.example.demo.Service.Impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.UserDetail1;
import com.example.demo.Entity.DTO.UserDTO;
import com.example.demo.Repository.UserRepo;
import com.example.demo.Service.UserService;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo userRepo;
	@Override
	public User getUserById(int id) {
		User user= userRepo.findUserByUid(id);
		String password = user.getPassword();
	return user;
	}
	@Override
	public User saveUser(UserDTO userDto) {
		User user = new User();
		user.setUsername(userDto.getUsername());
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = userDto.getPassword();
		String encoderPassword = passwordEncoder.encode(password);
		user.setPassword(encoderPassword);
		user.setEmail(userDto.getEmail());
		Date date = new Date();
		user.setCreate_at(date);
		return userRepo.save(user);
	}
	@Override
	public void updatePasswordByEmail(String newpassword, int id) {
		userRepo.updatePassword(newpassword, id);
		
	}
	@Override
	public User findByEmail(String email) {
	    return	userRepo.findUserByEmail(email);
		
	}
	public User getCurrentUser(Authentication authentication) {
		if(authentication== null) return null;
		User user = null;
		Object pricipal = authentication.getPrincipal();
		if(pricipal instanceof UserDetail1) {
			user = ((UserDetail1) pricipal).getUser();
			
					}
		return user;
	}
}
