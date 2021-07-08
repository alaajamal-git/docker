package com.example.controller.security;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import io.jsonwebtoken.Jwts;

public class TokenFilter extends BasicAuthenticationFilter{

	
	public TokenFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
	}

	@Override
	public void doFilterInternal(HttpServletRequest req,HttpServletResponse res,FilterChain chain) throws IOException, ServletException {
		
		String authorizedHeader=req.getHeader("Authorization");
		if(authorizedHeader==null || !authorizedHeader.startsWith("Bearer")) {
			chain.doFilter(req, res);
			return;
		}
		UsernamePasswordAuthenticationToken token=getToken(req);
		SecurityContextHolder.getContext().setAuthentication(token);
		chain.doFilter(req, res);
	}

	private UsernamePasswordAuthenticationToken getToken(HttpServletRequest req) {
		String authorizedHeader=req.getHeader("Authorization");
		String token=authorizedHeader.replace("Bearer", "");
		String email=Jwts.parser()
						.setSigningKey("LSSEcret1991")
						.parseClaimsJws(token)
						.getBody()
						.getSubject();
		
		if(email==null)return null;
		
		
		
		return new UsernamePasswordAuthenticationToken(email,null, new ArrayList<>());
	}

}