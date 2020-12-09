package com.group.touchefinale;

import java.io.IOException;
import java.util.Date;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.touchefinale.entities.Utilisateur;
import com.group.touchefinale.entities.Entreprise;
import com.group.touchefinale.entities.Postulant;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter 
{

	  private AuthenticationManager authenticationManager;
  
	  
	  public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
	  super(); 
	  this.authenticationManager = authenticationManager; }
	  
	  @Override 
	  public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) 
			  throws AuthenticationException { 
	  // TODO Auto-generated method stub
	  
	 // Client clt=null;
		  Entreprise clt=null;
	  
	  try { 
		  clt=new ObjectMapper().readValue(request.getInputStream(), Entreprise.class);
		  //clt=new ObjectMapper().readValue(request.getInputStream(), Postulant.class);
		  } catch (Exception e) {
			  throw new RuntimeException(" probleme utilisateur "+e); 
		 }
	  
	  System.out.println("********************");
	  System.out.println("mail Client "+clt.getMailutilisateur());
	  System.out.println("mot de passe client "+clt.getPasswordutilisateur()); 
	  
	  return authenticationManager.authenticate( new UsernamePasswordAuthenticationToken(clt.getMailutilisateur(),
	  clt.getPasswordutilisateur())); }
	  
	  @Override 
	  protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, 
			  FilterChain chain, Authentication authResult)
					  throws IOException, ServletException { 
		  		// TODO Auto-generated method stub
	  
	  User springUser=(User) authResult.getPrincipal();
	  
	  String jwtToken=Jwts.builder() .setSubject(springUser.getUsername()).setExpiration(new
	  Date(System.currentTimeMillis()+SecurityConstants.EXPIRATION_TIME)).signWith(SignatureAlgorithm.HS256, SecurityConstants.SECRET)
	  .claim("role", springUser.getAuthorities()).compact();
	  response.addHeader(SecurityConstants.HEADER_STRING, SecurityConstants.TOKEN_PREFIX+jwtToken);
	  
	  }
	 
}
