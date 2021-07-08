package com.example.controller.security;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.models.UserEntity;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


public class LogInFilter extends UsernamePasswordAuthenticationFilter{
	
	@Override
	public Authentication  attemptAuthentication(HttpServletRequest request, HttpServletResponse response) {
		UserEntity login=null;
		try {
			login = new ObjectMapper().readValue(request.getInputStream(), UserEntity.class);

		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return getAuthenticationManager().authenticate(new UsernamePasswordAuthenticationToken(login.getEmail(), login.getPassword(),new ArrayList<>()));
		
	}
	
	protected void successfulAuthentication(HttpServletRequest req,
            HttpServletResponse res,
            FilterChain chain,
            Authentication auth) throws IOException, ServletException {

		String token=Jwts.builder()
				 .setSubject(((User)auth.getPrincipal()).getUsername())
				 .setExpiration(new Date(System.currentTimeMillis()+19929399212L))
				 .signWith(SignatureAlgorithm.HS256, "LSSEcret1991")
				 .compact();
		System.out.println(token);
	res.addHeader("token", token);
		
	
	}
	

}
