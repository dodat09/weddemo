package com.example.demo.Entity.DTO;

public class UserDTO {
private int uid;
private String email;
private String username;
private String password;
public UserDTO() {
	
}
public UserDTO(int uid, String email, String username, String password) {
	super();
	this.uid = uid;
	this.email = email;
	this.username = username;
	this.password = password;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}

}
