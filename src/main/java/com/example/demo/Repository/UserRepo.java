package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.User;
@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
     
	User findUserByUsername(String username);
	User findUserByUid(int id);
	
	@Query(value="update user set password = :newpassword where uid= :id",nativeQuery=true)
	@Modifying
	void updatePassword(@Param("newpassword")String newpassword,@Param("id")int id);
	
	
	@Query(value="select * from user u where u.email = :email",nativeQuery=true)
	User findUserByEmail(@Param("email")String email);
}
