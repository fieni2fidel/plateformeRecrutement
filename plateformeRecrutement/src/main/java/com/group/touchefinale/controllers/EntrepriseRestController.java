package com.group.touchefinale.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.group.touchefinale.dao.EntrepriseRepository;
import com.group.touchefinale.dao.NivodaccesRepository;
import com.group.touchefinale.dao.UtilisateurRepository;
import com.group.touchefinale.entities.Entreprise;
import com.group.touchefinale.entities.Nivodacces;
import com.group.touchefinale.entities.Utilisateur;
import com.group.touchefinale.service.ModifyPassword;

@CrossOrigin("*")
@RestController
public class EntrepriseRestController {
	
	 @Autowired 
	 private BCryptPasswordEncoder bCryptPasswordEncoder;	 
	 
	 private AuthenticationManager authenticationManager;	 
	
	@Autowired
	private EntrepriseRepository entrepriseRepository; 
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private NivodaccesRepository nivodaccesRepository;
	
	@Autowired
	public JavaMailSender emailsender;
	
	public double nbrex=Math.random();
	  
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////:::
	
	@PostMapping("/modifypasswordentreprisesx")	
	public String modifypasswordEntreprise(@RequestBody Entreprise cl){
		
		Utilisateur user= utilisateurRepository.findByMailutilisateur(cl.getMailutilisateur());
		
		
		if(cl.getMotsecret().equals(user.getMailutilisateur())) {
			
			user.setPasswordutilisateur(cl.getPasswordutilisateur());
			
			String hashPW=bCryptPasswordEncoder.encode(user.getPasswordutilisateur());
			  user.setPasswordutilisateur(hashPW);	
			  
			  utilisateurRepository.save(user); 
			
			  return "ok";
		}else {
			
			throw new RuntimeException("Mot de passe incorrect");	        
	        
		}		
		
	}
		
	
	@PostMapping("/testentreprisesx")	
	public String TestEntreprise(@RequestBody Entreprise cl) {
		
		Utilisateur user= utilisateurRepository.findByMailutilisateur(cl.getMailutilisateur());
		
		if(user==null) {
			throw new RuntimeException("Ce mail est inexistant");
		}else {
			
			System.out.println("affichage du mail ==> "+cl.getMailutilisateur());
			System.out.println("affichage de user ==> "+user.getIdutilisateur()+" "+user.getPasswordutilisateur());
			
			String AA="yrt!dhb"+nbrex+"vcdgfh@gd";
			
			 user.setPasswordutilisateur(AA); 
			
			
			  String hashPW=bCryptPasswordEncoder.encode(user.getPasswordutilisateur());
			  user.setPasswordutilisateur(hashPW);			 
			
			
			SimpleMailMessage message = new SimpleMailMessage();
	        
	        message.setTo("touchefinale4@gmail.com");
	        message.setSubject("Recrutement 2.0");
	        message.setText("Hello, votre nouveau de passe est <strong> "+ AA+"</strong>");
	 
	        // Send Message!
	        this.emailsender.send(message);
	        
			 utilisateurRepository.save(user); 
	        
	        return "Email Sent!";
		}		
		
	}
	
	
	@GetMapping("/entreprisesearch")
	public Page<Entreprise> listeEntreprisex(
			@RequestParam(name = "recruteur", defaultValue = "") String recruteur,
			@RequestParam(name = "entreprise", defaultValue = "") String entreprise,
			@RequestParam(name = "ville", defaultValue = "") String ville,
			@RequestParam(name = "pays", defaultValue = "") String pays,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size){	
		
		Page<Entreprise>cl=entrepriseRepository.entre
				("%"+recruteur+"%","%"+entreprise+"%","%"+ville+"%","%"+pays+"%",PageRequest.of(page,size,Sort.by("idutilisateur").descending()));
		
		return cl;		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	
	@GetMapping("/mailutilisateur/{mail}")
	public Utilisateur mailutilisateur(@PathVariable(name="mail") String mailuser) {
		
		return utilisateurRepository.findByMailutilisateur(mailuser);
	}
	
	
	@GetMapping("/entreprisesx")
	public List<Entreprise> listeEntreprise(){	
		List<Entreprise>cl=entrepriseRepository.findAll();
		return cl;		
	}
	
	@GetMapping("/entreprisesx/{id}")
	public Entreprise listeEntrepriseId(@PathVariable(name="id") Long id) {		
		//	Client clt=clientRepository.getOne(id);

		return entrepriseRepository.findById(id).get();
	}
	
	
	@PostMapping("/entreprisesx")	
	public Entreprise saveEntreprise(@RequestBody Entreprise cl) {
		
		Utilisateur user= utilisateurRepository.findByMailutilisateur(cl.getMailutilisateur());
		if(user!=null) throw new RuntimeException("Ce mail est deja utilise");
		
		 String hashPW=bCryptPasswordEncoder.encode(cl.getPasswordutilisateur());
		 cl.setPasswordutilisateur(hashPW);
		cl.setDatecreationutilisateur(new Date());
		
		return entrepriseRepository.save(cl);
	}
	
	
	
	@PutMapping("/entreprisesx/{id}")
	public Entreprise updateEntreprise(@RequestBody Entreprise cl, @PathVariable(name="id") Long id) {		
		cl.setIdutilisateur(id);
		 
		return entrepriseRepository.save(cl);
	}
	
	@DeleteMapping("entreprisesx/{id}")
	public List<Entreprise> deleteEntreprise(@PathVariable(name="id") Long id) {
		entrepriseRepository.deleteById(id);			
			return entrepriseRepository.findAll();
	}
}
