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

import com.group.touchefinale.dao.DiplomeRepository;
import com.group.touchefinale.entities.Diplome;

@CrossOrigin("*")
@RestController
public class DiplomeController {
		
		@Autowired
		private DiplomeRepository diplomeRepository; 
		
		@GetMapping("/diplomesx")
		public List<Diplome> listeDiplome(){	
			List<Diplome>cl=diplomeRepository.findAll();
			return cl;		
		}
		
		@GetMapping("/diplomesx/{id}")
		public Diplome listeDiplomeId(@PathVariable(name="id") Long id) {		
			//	Client clt=clientRepository.getOne(id);
			return diplomeRepository.findById(id).get();
		}
		
		
		@PostMapping("/diplomesx")	
		public Diplome saveDiplome(@RequestBody Diplome cl) {
			
			return diplomeRepository.save(cl);
		}
		
		@PutMapping("/diplomesx/{id}")
		public Diplome updateDiplome(@RequestBody Diplome cl, @PathVariable(name="id") Long id) {
			cl.setIddiplome(id);
			return diplomeRepository.save(cl);
		}
		
		@DeleteMapping("diplomesx/{id}")
		public List<Diplome> deleteDiplome(@PathVariable(name="id") Long id) {
			diplomeRepository.deleteById(id);			
				return diplomeRepository.findAll();
		}


	}