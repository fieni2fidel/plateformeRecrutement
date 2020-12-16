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

import com.group.touchefinale.dao.CurrivitaeRepository;
import com.group.touchefinale.entities.Currivitae;

	@CrossOrigin("*")
	@RestController
	public class CurrivitaeController {
		
		@Autowired
		private CurrivitaeRepository currivitaeRepository; 
		
		@GetMapping("/currivitaesx")
		public List<Currivitae> listeCurrivitae(){	
			List<Currivitae>cl=currivitaeRepository.findAll();
			return cl;		
		}
		
		@GetMapping("/currivitaesx/{id}")
		public Currivitae listeCurrivitaeId(@PathVariable(name="id") Long id) {		
			//	Client clt=clientRepository.getOne(id);
			return currivitaeRepository.findById(id).get();
		}
		
		
		@PostMapping("/currivitaesx")	
		public Currivitae saveCurrivitae(@RequestBody Currivitae cl) {
			
			return currivitaeRepository.save(cl);
		}
		
		@PutMapping("/currivitaesx/{id}")
		public Currivitae updateCurrivitae(@RequestBody Currivitae cl, @PathVariable(name="id") Long id) {
			cl.setIdcurrivitae(id);
			return currivitaeRepository.save(cl);
		}
		
		@DeleteMapping("currivitaesx/{id}")
		public List<Currivitae> deleteCurrivitae(@PathVariable(name="id") Long id) {
			currivitaeRepository.deleteById(id);			
				return currivitaeRepository.findAll();
		}


	}