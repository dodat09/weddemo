package com.example.demo.Service;

import com.example.demo.Entity.User;
import com.example.demo.Entity.DTO.UserDTO;

public interface UserService {
 User getUserById(int id);
 User saveUser(UserDTO userDto);
 
 void updatePasswordByEmail(String newpassword,int id);
 
 User findByEmail(String email);
 }