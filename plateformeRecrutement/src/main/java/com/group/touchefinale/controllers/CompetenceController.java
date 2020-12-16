package com.group.touchefinale.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.group.touchefinale.dao.CompetenceRepository;
import com.group.touchefinale.entities.Competence;

@CrossOrigin("*")
@RestController
public class CompetenceController {
	
	@Autowired
	private CompetenceRepository competenceRepository; 
	
	@GetMapping("/competencesx")
	public List<Competence> listeCompetence(){	
		List<Competence>cl=competenceRepository.findAll();
		return cl;		
	}
	
	@GetMapping("/competencesx/{id}")
	public Competence listeCompetenceId(@PathVariable(name="id") Long id) {		
		//	Client clt=clientRepository.getOne(id);
		return competenceRepository.findById(id).get();
	}
	
	
	@PostMapping("/competencesx")	
	public Competence saveCompetence(@RequestBody Competence cl) {
		
		return competenceRepository.save(cl);
	}
	
	@PutMapping("/competencesx/{id}")
	public Competence updateCompetence(@RequestBody Competence cl, @PathVariable(name="id") Long id) {
		cl.setIdcompetence(id);
		return competenceRepository.save(cl);
	}
	
	@DeleteMapping("competencesx/{id}")
	public List<Competence> deleteCompetence(@PathVariable(name="id") Long id) {
		competenceRepository.deleteById(id);			
			return competenceRepository.findAll();
	}


}
