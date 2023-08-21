package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int uid;
@Column
private String uname;
@Column
private String password;
public User() {
	
}
public User(int uid, String uname, String password) {
	super();
	this.uid = uid;
	this.uname = uname;
	this.password = password;
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
}
public String getUname() {
	return uname;
}
public void setUname(String uname) {
	this.uname = uname;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}


}
