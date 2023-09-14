package com.example.demo.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column
private String gender;
@Column
private String email;
@Column
private Date birthday;
@Column
private String phone;
@Column
private String address;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="user_id" , referencedColumnName="id")
private User user;
@OneToOne(mappedBy="cart")
private Cart cart;
public Customer() {
	
}
public Customer(int id, String gender, String email, Date birthday, String phone, String address, User user,
		Cart cart) {
	super();
	this.id = id;
	this.gender = gender;
	this.email = email;
	this.birthday = birthday;
	this.phone = phone;
	this.address = address;
	this.user = user;
	this.cart = cart;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
public Cart getCart() {
	return cart;
}
public void setCart(Cart cart) {
	this.cart = cart;
}


}
