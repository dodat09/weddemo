package com.example.demo.Entity;

import java.util.Collection;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;

public class UserDetail1 implements org.springframework.security.core.userdetails.UserDetails{
 private User user;
  Set<GrantedAuthority> authority = null;
  
  
public User getUser() {
	return user;
}
public void setUser(User user) {
	this.user = user;
}
@Override
public Collection<? extends GrantedAuthority> getAuthorities() {
	// TODO Auto-generated method stub
	return authority;
}
@Override
public String getPassword() {
	// TODO Auto-generated method stub
	return user.getPassword();
}
@Override
public String getUsername() {
	// TODO Auto-generated method stub
	return user.getUsername();
}
@Override
public boolean isAccountNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isAccountNonLocked() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isCredentialsNonExpired() {
	// TODO Auto-generated method stub
	return true;
}
@Override
public boolean isEnabled() {
	// TODO Auto-generated method stub
	return true;
}
  

	
}
