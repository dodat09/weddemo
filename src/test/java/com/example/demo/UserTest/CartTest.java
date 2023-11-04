package com.example.demo.UserTest;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.example.demo.Entity.CartItem;
import com.example.demo.Entity.Product;
import com.example.demo.Entity.User;
import com.example.demo.Repository.CartItemRepo;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class CartTest {
	@Autowired
	private CartItemRepo cartRepo;
	@Autowired
	private TestEntityManager entityManager;
	
   @Test
   public void testCreateCart() {
	 CartItem cart = new CartItem();
	 Product product = entityManager.find(Product.class, 2);
	 User user = entityManager.find(User.class,1);
	 cart.setCreateCart(LocalDateTime.now());
	 cart.setUpdateCart(LocalDateTime.now());
	
	 cart.setUser(user);
	 cart.setProduct(product);
	 cart.setPrice( (int)product.getPrice());
	 cart.setQuantity(1);
	 
	 cartRepo.save(cart);
   }
	
	
}
