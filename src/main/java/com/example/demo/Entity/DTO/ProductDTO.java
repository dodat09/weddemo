package com.example.demo.Entity.DTO;

public class ProductDTO {
private int pid;
private String name;
private float price;
private float star;
private String description;
private String size;
private String color;
private String image;
private CategoryDTO categoryDTO;
public ProductDTO() {
	
}
public ProductDTO(int pid, String name, float price, float star, String description, String size, String color,
		String image, CategoryDTO categoryDTO) {
	super();
	this.pid = pid;
	this.name = name;
	this.price = price;
	this.star = star;
	this.description = description;
	this.size = size;
	this.color = color;
	this.image = image;
	this.categoryDTO = categoryDTO;
}
public int getPid() {
	return pid;
}
public void setPid(int pid) {
	this.pid = pid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public CategoryDTO getCategoryDTO() {
	return categoryDTO;
}
public void setCategoryDTO(CategoryDTO categoryDTO) {
	this.categoryDTO = categoryDTO;
}

}
