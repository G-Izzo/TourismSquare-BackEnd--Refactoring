package it.ibs.tourismsquare.config.jwt;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtils {
	private String secret;

	@Value("${jwt.secret}")
	public void setSecret(String secret) {
		this.secret = secret;
	}
	
	public String generateToken(String subject) {	
		return Jwts.builder().setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).signWith(SignatureAlgorithm.HS512, secret).compact();
	}
}
