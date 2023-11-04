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
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
		    .antMatchers("/css/**","/img/**","/img/**","/js/**","/lib/**","/mail/**","/scss/**").permitAll()
	        .antMatchers("/home","/shop","/pass","/sighup","/register","/send_email","/verifyOtp","/change_password").permitAll()
	        .antMatchers("/userInfor").permitAll()
	        .antMatchers("/admin").permitAll()
	        .anyRequest().authenticated()
	        .and()
	     .formLogin()
	        .loginProcessingUrl("/j_spring_security_check")
	        .loginPage("/login").permitAll()
	        .usernameParameter("username")
	        .passwordParameter("password")
	        .defaultSuccessUrl("/home",true)
	        .failureUrl("/login?success=fail")
	        .and()
	        .logout()
	        .logoutUrl("/logout")
	        .logoutSuccessUrl("/")
	        .deleteCookies("JSESSIONID")
	        .invalidateHttpSession(true)
	       
	        ;
	     
	    
	}
	
}
