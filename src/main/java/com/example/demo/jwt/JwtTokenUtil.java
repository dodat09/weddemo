package com.example.demo.jwt;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.example.demo.Entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class JwtTokenUtil {
	    private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);
        private static final long ex = 24*60;
        private static final String secretkey = "DAT";
   public String generatrAccessToken(User user) {
	   return Jwts.builder()
			      .setSubject(user.getUsername()+","+user.getEmail())
			      .setIssuer(user.getUsername())
			      .setIssuedAt(new Date(System.currentTimeMillis()+ex))
			      .setExpiration(new Date(ex))
			      .signWith(SignatureAlgorithm.HS256,secretkey)
			      .compact();
   }
 public boolean validateAccessToken(String accessToken) {
	 try {
		 Jwts.parser().setSigningKey(secretkey).parseClaimsJws(accessToken);
		 return true;
	 }catch(ExpiredJwtException ex) {
		 log.error("Jwt expiration ",ex);
	 }catch(IllegalArgumentException ex) {
		 log.error("Token is null",ex);
	 }catch(MalformedJwtException ex) {
		 log.error("jwt in valid",ex);
	 }catch(SignatureException ex) {
		 log.error("Signature valid",ex);
	 }
	 return false;
 }
 public String getSubject(String accessToken ) {
	 return parseClaim(accessToken).getSubject();
 }
 public Claims parseClaim(String accessToken) {
	 return Jwts.parser()
			    .setSigningKey(secretkey)
			    .parseClaimsJws(accessToken)
			    .getBody();
 }
}
