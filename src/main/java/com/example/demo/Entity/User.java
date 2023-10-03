package com.example.demo.Entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


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
@ManyToMany
@JoinTable(name="user_role",
           joinColumns = @JoinColumn(name="user_id"),
           inverseJoinColumns= @JoinColumn(name="role_id")
		)
private Set<Role> role;

@OneToOne(mappedBy="user")
private Customer customer;
public User() {
	
}
public User(int uid, String username, String password ) {
	super();
	this.uid = uid;
	this.username = username;
	this.password = password;
	
}
public int getUid() {
	return uid;
}
public void setUid(int uid) {
	this.uid = uid;
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
public Set<Role> getRole() {
	return role;
}
public void setRole(Set<Role> role) {
	this.role = role;
}
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}

}