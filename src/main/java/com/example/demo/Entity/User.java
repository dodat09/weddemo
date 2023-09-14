package com.example.demo.Entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Setter
@Getter

@Entity
@Table(name="user")
public class User {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int uid;
@Column
private String username;
@Column
private String password;
@Column
private int status;
@Column
private Date create_at;
@ManyToOne
@JoinColumn(name="roleid")
private Role role;
@OneToOne(mappedBy="user")
private Customer customer;
public User() {
	
}
public User(int uid, String username, String password, int status, Date create_at, Role role, Customer customer) {
	super();
	this.uid = uid;
	this.username = username;
	this.password = password;
	this.status = status;
	this.create_at = create_at;
	this.role = role;
	this.customer = customer;
}

public void setUid(int uid) {
	this.uid = uid;
}
public int getUid() {
	return uid;
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
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
}
public Date getCreate_at() {
	return create_at;
}
public void setCreate_at(Date create_at) {
	this.create_at = create_at;
}
public Role getRole() {
	return role;
}
public void setRole(Role role) {
	this.role = role;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}

}
