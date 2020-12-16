package com.group.touchefinale.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

import com.group.touchefinale.dao.EntrepriseRepository;
import com.group.touchefinale.dao.NivodaccesRepository;
import com.group.touchefinale.dao.PostulantRepository;
import com.group.touchefinale.dao.UtilisateurRepository;
import com.group.touchefinale.entities.Entreprise;
import com.group.touchefinale.entities.Postulant;
import com.group.touchefinale.entities.Utilisateur;

@CrossOrigin("*")
@RestController
public class PostulantRestController {


	@Autowired
	private PostulantRepository postulantRepository; 
	
	 @Autowired 
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	 
	
	@Autowired
	private EntrepriseRepository entrepriseRepository; 
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	
	@Autowired
	private NivodaccesRepository nivodaccesRepository;
	
	
	public Utilisateur mailutilisatuer(String mailuser) {
		
		return utilisateurRepository.findByMailutilisateur(mailuser);
	}
	
	@PostMapping("/modifypasswordpostulantsx")	
	public String modifypasswordPostulant(@RequestBody Postulant cl){
		
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
	
	
	@GetMapping("/postulantsearch")
	public Page<Postulant> listePostulantx(
			@RequestParam(name = "nom", defaultValue = "") String nom,
			@RequestParam(name = "prenom", defaultValue = "") String prenom,
			@RequestParam(name = "ville", defaultValue = "") String ville,
			@RequestParam(name = "pays", defaultValue = "") String pays,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "10") int size){	
		
		Page<Postulant>cl=postulantRepository.postulan
				("%"+nom+"%","%"+prenom+"%","%"+ville+"%","%"+pays+"%",PageRequest.of(page,size,Sort.by("idutilisateur").descending()));
		
		return cl;		
	}
	
	///////////////////////////////////////////////////////////////////////////////
	
	
	@GetMapping("/postulantsx")
	public List<Postulant> listePostulant(){	
		List<Postulant>cl=postulantRepository.findAll();
		return cl;		
	}
	
	@GetMapping("/postulantsx/{id}")
	public Postulant listePostulantId(@PathVariable(name="id") Long id) {		
		//	Client clt=clientRepository.getOne(id);
		return postulantRepository.findById(id).get();
	}
	
	
	@PostMapping("/postulantsx")	
	public Postulant savePostulant(@RequestBody Postulant cl) {
		
		Utilisateur user= utilisateurRepository.findByMailutilisateur(cl.getMailutilisateur());
		if(user!=null) throw new RuntimeException("Ce mail est deja utilise");
		
		 String hashPW=bCryptPasswordEncoder.encode(cl.getPasswordutilisateur());
		 cl.setPasswordutilisateur(hashPW);
		cl.setDatecreationutilisateur(new Date());
		
		return postulantRepository.save(cl);
	}
	
	@PutMapping("/postulantsx/{id}")
	public Postulant updatePostulant(@RequestBody Postulant cl, @PathVariable(name="id") Long id) {		
		cl.setIdutilisateur(id);		
		return postulantRepository.save(cl);
	}
	
	@DeleteMapping("postulantsx/{id}")
	public List<Postulant> deletePostulant(@PathVariable(name="id") Long id) {
		postulantRepository.deleteById(id);			
			return postulantRepository.findAll();
	}
}
