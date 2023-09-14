package com.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Cart;
@Repository
public interface CartRepo extends JpaRepository<Cart,Integer>{

}
