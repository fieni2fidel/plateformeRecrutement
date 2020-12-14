package com.group.touchefinale.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.group.touchefinale.dao.AnnonceRepository;
import com.group.touchefinale.dao.EntrepriseRepository;
import com.group.touchefinale.dao.NivodaccesRepository;
import com.group.touchefinale.entities.Annonce;
import com.group.touchefinale.entities.Entreprise;
import com.group.touchefinale.entities.Mission;
import com.group.touchefinale.entities.Nivodacces;

@CrossOrigin("*")
@RestController
public class AnnonceRestController {
	
	@Autowired
	private AnnonceRepository annonceRepository;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	
	  @GetMapping("/annoncesatconstraintUn/{idutilisateur}")
	  public List<Annonce>listeAnnonceAtConstraintUn(@PathVariable(name="idutilisateur") Long idutilisateur){
	  List<Annonce>listcl=annonceRepository.findByIdentreprise(idutilisateur); 
	  return listcl;
	  }
	  
	  @GetMapping("/annoncesatconstraintMail/{mailutilisateur}")
	  public List<Annonce>listeAnnonceAtConstraintMail(@PathVariable(name="mailutilisateur") String mailutilisateur){
	  List<Annonce>listcl=annonceRepository.findByMailentreprise(mailutilisateur); 
	  return listcl;
	  }
	  
	  @GetMapping("/annoncesatconstraintmailsearch")
	  public Page<Annonce>listeAnnonceAtConstraintMailSearch(
		@RequestParam(name="mail") String mailutilisateur,
		@RequestParam(name = "annonce", defaultValue = "") String annonce,
		@RequestParam(name = "ville", defaultValue = "") String ville,
		@RequestParam(name = "pays", defaultValue = "") String pays,
		@RequestParam(name = "page", defaultValue = "0") int page,
		@RequestParam(name = "size", defaultValue = "10") int size)
	  {
	  Page<Annonce>listcl=annonceRepository.findByMailentreprisex(mailutilisateur,
			  "%"+annonce+"%","%"+ville+"%","%"+pays+"%",
				PageRequest.of(page,size,Sort.by("idannonce").descending())); 
	  return listcl;
	  }
	 
	  
		@GetMapping("/annoncesearch")
		public Page<Annonce> listeAnnoncex(
				@RequestParam(name = "annonce", defaultValue = "") String annonce,
				@RequestParam(name = "entreprise", defaultValue = "") String entreprise,
				@RequestParam(name = "ville", defaultValue = "") String ville,
				@RequestParam(name = "pays", defaultValue = "") String pays,
				@RequestParam(name = "page", defaultValue = "0") int page,
				@RequestParam(name = "size", defaultValue = "10") int size){	
			
			Page<Annonce>cl=annonceRepository.annonx
					("%"+annonce+"%","%"+entreprise+"%","%"+ville+"%","%"+pays+"%",
							PageRequest.of(page,size,Sort.by("idannonce").descending()));
			
			return cl;		
		}
	
	/*
	 * @GetMapping("/annoncesatconstraintDeux/{id}") public List<Annonce>
	 * listeAnnonceAtConstraintDeux(@PathVariable(name="id") Long id){
	 * List<Annonce>listcl=annonceRepository.findAnnonceWithUtilisateur(id); return
	 * listcl; }
	 */
	  
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/annoncesx")
	public List<Annonce> listeAnnonce(){	
		List<Annonce>cl=annonceRepository.findAll();
		return cl;		
	}
	
	@GetMapping("/annoncesx/{id}")
	public Annonce listeAnnonceId(@PathVariable(name="id") Long id) {		
		//	Client clt=clientRepository.getOne(id);
		return annonceRepository.findById(id).get();
	}
	
	
	@PostMapping("/annoncesx")	
	public Annonce saveAnnonce(@RequestBody Annonce cl) {
		
		cl.setDatecreationannonce(new Date());
		
		System.out.println("les donnees de get Entreprise ==> "+cl.getEntreprise());
		//cl.setEntreprise(cl.getEntreprise());
		
		return annonceRepository.save(cl);
	}
	
	@PutMapping("/annoncesx/{id}")
	public Annonce updateAnnonce(@RequestBody Annonce cl, @PathVariable(name="id") Long id) {
		cl.setIdannonce(id);
		return annonceRepository.save(cl);
	}
	
	@DeleteMapping("annoncesx/{id}")
	public List<Annonce> deleteAnnonce(@PathVariable(name="id") Long id) {
		annonceRepository.deleteById(id);			
			return annonceRepository.findAll();
	}

}
