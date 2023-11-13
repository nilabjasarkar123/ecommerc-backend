package com.ecommerce.config;



import java.sql.Date;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	
	SecretKey key = Keys.hmacShaKeyFor(jwtConstant.SECRET_KEY.getBytes());
	
	public String genarateTokens(Authentication auth) {
		String jwt = Jwts.builder().setIssuedAt(new Date())
				     .setExpiration(new Date(new Date().getTime()+846000000))
					 .claim("email", auth.getName())
					 .signWith(key).compact();
	}
}
