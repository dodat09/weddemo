package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
@Column
private String cname;
@OneToMany(mappedBy="category",orphanRemoval=true)
private Set<Product> product;
public Category() {
	
}
public Category(int id, String cname, Set<Product> product) {
	super();
	this.id = id;
	this.cname = cname;
	this.product = product;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public Set<Product> getProduct() {
	return product;
}
public void setProduct(Set<Product> product) {
	this.product = product;
}
	

}
