package com.example.demo.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Role;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepo;
@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepo userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepo.findUserByUsername(username);
		if(user==null) {
			throw  new UsernameNotFoundException("User not found with " + user.getUsername());
		}
		return new org.springframework.security.core.userdetails.User(
				user.getUsername(),
				user.getPassword(),
				getAuthority(user.getRole()));
				
	}
	private List<GrantedAuthority> getAuthority(Set<Role> roles) {
		List<GrantedAuthority> authority = new ArrayList<>();
		for(Role role:roles) {
			authority.add(new SimpleGrantedAuthority(role.getName()));
		}
		
		return authority;
	}

}
