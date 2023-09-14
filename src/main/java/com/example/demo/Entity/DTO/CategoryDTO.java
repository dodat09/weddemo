package com.example.demo.Entity.DTO;

public class CategoryDTO {
private int id;
private String cname;
private String image;
public CategoryDTO() {
	
}
public CategoryDTO(int id, String cname, String image) {
	super();
	this.id = id;
	this.cname = cname;
	this.image = image;
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
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}

}
