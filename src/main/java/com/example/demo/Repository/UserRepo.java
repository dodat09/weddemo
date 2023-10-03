package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
     
	User findUserByUsername(String username);
	User findUserByUid(int id);
	
}
