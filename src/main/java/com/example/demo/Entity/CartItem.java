package com.example.demo.Entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="cartItem")
public class CartItem {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="user_id")
	private User user;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product product;
	
	private int quantity;
	
	private int price;
	
	private LocalDateTime createCart;
	
	private LocalDateTime updateCart;

	public CartItem() {
		
	}

	public CartItem(int id, User user, Product product, int quantity, int price, LocalDateTime createCart,
			LocalDateTime updateCart) {
		super();
		this.id = id;
		this.user = user;
		this.product = product;
		this.quantity = quantity;
		this.price = price;
		this.createCart = createCart;
		this.updateCart = updateCart;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getCreateCart() {
		return createCart;
	}

	public void setCreateCart(LocalDateTime createCart) {
		this.createCart = createCart;
	}

	public LocalDateTime getUpdateCart() {
		return updateCart;
	}

	public void setUpdateCart(LocalDateTime updateCart) {
		this.updateCart = updateCart;
	}

	
}
