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

import com.group.touchefinale.dao.ExperienceprofRepository;
import com.group.touchefinale.entities.Experienceprof;

@CrossOrigin("*")
@RestController
public class ExperienceprofController {
		
		@Autowired
		private ExperienceprofRepository experienceprofRepository; 
		
		@GetMapping("/experienceprofsx")
		public List<Experienceprof> listeExperienceprof(){	
			List<Experienceprof>cl=experienceprofRepository.findAll();
			return cl;		
		}
		
		@GetMapping("/experienceprofsx/{id}")
		public Experienceprof listeExperienceprofId(@PathVariable(name="id") Long id) {		
			//	Client clt=clientRepository.getOne(id);
			return experienceprofRepository.findById(id).get();
		}
		
		
		@PostMapping("/experienceprofsx")	
		public Experienceprof saveExperienceprof(@RequestBody Experienceprof cl) {
			
			return experienceprofRepository.save(cl);
		}
		
		@PutMapping("/experienceprofsx/{id}")
		public Experienceprof updateExperienceprof(@RequestBody Experienceprof cl, @PathVariable(name="id") Long id) {
			cl.setIdexperienceprof(id);
			return experienceprofRepository.save(cl);
		}
		
		@DeleteMapping("experienceprofsx/{id}")
		public List<Experienceprof> deleteExperienceprof(@PathVariable(name="id") Long id) {
			experienceprofRepository.deleteById(id);			
				return experienceprofRepository.findAll();
		}


	}