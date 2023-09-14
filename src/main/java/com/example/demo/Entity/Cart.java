package com.example.demo.Entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="cart")
public class Cart {
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column
private int total;
@Column
private int quantity;
@OneToOne(cascade=CascadeType.ALL)
@JoinColumn(name="customer_id",referencedColumnName="id")
private Customer customer;
@OneToMany(mappedBy="cart" ,cascade=CascadeType.ALL,orphanRemoval=true)
private List<Product> products;
public Cart() {
	
}
public Cart(int id, int total, int quantity, Customer customer, List<Product> products) {
	super();
	this.id = id;
	this.total = total;
	this.quantity = quantity;
	this.customer = customer;
	this.products = products;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getTotal() {
	return total;
}
public void setTotal(int total) {
	this.total = total;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public List<Product> getProducts() {
	return products;
}
public void setProducts(List<Product> products) {
	this.products = products;
}

}
