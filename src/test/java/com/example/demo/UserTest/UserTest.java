package com.example.demo.UserTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserTest {
 @Autowired UserRepo repo;
 
 @Test
 public void testCreateUser() {
	 PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	 String rawPassword="123";
	
	 String encodePassword= passwordEncoder.encode(rawPassword);
	
	// User newUser= new User(1,"dat123",encodePassword);
	// User saveUser=repo.save(newUser);
//	 assertThat(saveUser).isNotNull();
//	 assertThat(saveUser.getUid()).isGreaterThan(0);
 }
}
