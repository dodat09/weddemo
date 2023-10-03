package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.demo.Service.UserDetailServiceImpl;
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UserDetailServiceImpl userDetail;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetail).passwordEncoder(passwordEncoder());
	}
	// cáu hình mã hóa mật khẩu khi truyền vào
	@Bean
	protected PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		    .antMatchers("/css/**","/img/**","/img/**","/js/**","/lib/**","/mail/**","/scss/**").permitAll()
	        .antMatchers("/home","/shop","/pass").permitAll()
	        .antMatchers("/userInfor").access("hashAnyRole('Role_User','Role_Admin')")
	        .antMatchers("/admin").access("hashRole('Role_Admin')")
	        .anyRequest().authenticated()
	        .and()
	     .formLogin()
	        .loginPage("/login").permitAll()
	        .loginProcessingUrl("j_spring_security_check")
	        .defaultSuccessUrl("/home")
	        .failureUrl("/login?success=fail")
	        
	       
	        ;
	     
	    
	}
	
}
