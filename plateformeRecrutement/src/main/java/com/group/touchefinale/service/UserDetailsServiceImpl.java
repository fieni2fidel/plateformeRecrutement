package com.group.touchefinale.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.group.touchefinale.dao.EntrepriseRepository;
import com.group.touchefinale.dao.UtilisateurRepository;
import com.group.touchefinale.entities.Entreprise;
import com.group.touchefinale.entities.Utilisateur;


@Service
public class UserDetailsServiceImpl implements UserDetailsService 
{

	
	  @Autowired 
	  private UtilisateurRepository utilisateurRepository;
	  
	  @Autowired 
	  private EntrepriseRepository entrepriseRepository;
	 // private ClientService clientService;
	  
	  @Override 
	  public UserDetails loadUserByUsername(String mailutilisateur) throws UsernameNotFoundException { 
	  // TODO Auto-generated method stub Client
	// Entreprise clt=entrepriseRepository.findByMailutilisateur(mailutilisateur);
	 
	 Utilisateur clt=utilisateurRepository.findByMailutilisateur(mailutilisateur);
			 // clientService.findByMailclient(mailclient); 
		  if(clt==null) throw new UsernameNotFoundException(mailutilisateur);
		  
	  Collection<GrantedAuthority>authorithies=new ArrayList<>();
	  authorithies.add(new
	  SimpleGrantedAuthority(clt.getNivodacces().getNomnivodacces()));
			//  getAuthrole().getNomauthrole()));
	  
	  return new User(clt.getMailutilisateur(),clt.getPasswordutilisateur(),authorithies); 
	  }
	 
}
