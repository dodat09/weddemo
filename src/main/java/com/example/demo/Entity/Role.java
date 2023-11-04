package com.example.demo.Entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
 
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int id;
@Column
private String name;
@Column
private String code;
@ManyToMany(mappedBy="role",cascade=CascadeType.ALL)
private Set<User> user;
public Role() {
	
}
public Role(int id, String name, String code, Set<User> user) {
	super();
	this.id = id;
	this.name = name;
	this.code = code;
	this.user = user;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCode() {
	return code;
}
public void setCode(String code) {
	this.code = code;
}
public Set<User> getUser() {
	return user;
}
public void setUser(Set<User> user) {
	this.user = user;
}


}
