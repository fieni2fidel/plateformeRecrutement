package com.group.touchefinale.controllers;

import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.touchefinale.dao.EntrepriseRepository;
import com.group.touchefinale.dao.NivodaccesRepository;
import com.group.touchefinale.dao.UtilisateurRepository;
import com.group.touchefinale.entities.Entreprise;
import com.group.touchefinale.entities.Nivodacces;
import com.group.touchefinale.entities.Utilisateur;

@CrossOrigin("*")
@RestController
public class EntrepriseRestController {
	
	/*
	 * @Autowired private AuthroleRepository authroleRepository;
	 */
	
	
	 @Autowired 
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	
	@Autowired
	private EntrepriseRepository entrepriseRepository; 
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private NivodaccesRepository nivodaccesRepository;
	
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
