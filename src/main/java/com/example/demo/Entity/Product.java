package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product {

@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int pid;
@Column
private String pname;
@Column
private float price;
@Column
private float star;
@Column
private String description;
@Column
private String size;
@Column
private String color;
@Column
private String image;
@ManyToOne(fetch=FetchType.LAZY)
@JoinColumn(name="cid")
private Category category;



public Product() {
	
}


public Product(int pid, String pname, float price, float star, String description, String size, String color,
		String image, Category category) {
	super();
	this.pid = pid;
	this.pname = pname;
	this.price = price;
	this.star = star;
	this.description = description;
	this.size = size;
	this.color = color;
	this.image = image;
	this.category = category;

}


public int getPid() {
	return pid;
}


public void setPid(int pid) {
	this.pid = pid;
}


public String getPname() {
	return pname;
}


public void setPname(String pname) {
	this.pname = pname;
}


public float getPrice() {
	return price;
}


public void setPrice(float price) {
	this.price = price;
}


public float getStar() {
	return star;
}


public void setStar(float star) {
	this.star = star;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getSize() {
	return size;
}


public void setSize(String size) {
	this.size = size;
}


public String getColor() {
	return color;
}


public void setColor(String color) {
	this.color = color;
}


public String getImage() {
	return image;
}


public void setImage(String image) {
	this.image = image;
}


public Category getCategory() {
	return category;
}


public void setCategory(Category category) {
	this.category = category;
}






}
