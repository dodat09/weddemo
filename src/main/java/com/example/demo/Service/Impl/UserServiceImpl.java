package com.example.demo.Service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.User;
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
}
