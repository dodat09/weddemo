package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.CartItem;
import com.example.demo.Entity.User;
@Repository
public interface CartItemRepo extends JpaRepository<CartItem,Integer>{
	
	List<CartItem> findByUser(User user);
	
	@Query(value="select * from cart_item where user_id = :uid",nativeQuery=true)
	List<CartItem> findCartByUid(@Param("uid") int uid);
}
