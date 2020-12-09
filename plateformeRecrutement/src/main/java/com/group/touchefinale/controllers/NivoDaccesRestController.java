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

import com.group.touchefinale.dao.NivodaccesRepository;
import com.group.touchefinale.entities.Nivodacces;

@CrossOrigin("*")
@RestController
public class NivoDaccesRestController {
	
	@Autowired
	private NivodaccesRepository nivodaccesRepository; 
	
	@GetMapping("/nivodaccesesx")
	public List<Nivodacces> listeNivodacces(){	
		List<Nivodacces>cl=nivodaccesRepository.findAll();
		return cl;		
	}
	
	@GetMapping("/nivodaccesesx/{id}")
	public Nivodacces listeNivodaccesId(@PathVariable(name="id") Long id) {		
		//	Client clt=clientRepository.getOne(id);
		return nivodaccesRepository.findById(id).get();
	}
	
	
	@PostMapping("/nivodaccesesx")	
	public Nivodacces saveNivodacces(@RequestBody Nivodacces cl) {
		
		return nivodaccesRepository.save(cl);
	}
	
	@PutMapping("/nivodaccesesx/{id}")
	public Nivodacces updateNivodacces(@RequestBody Nivodacces cl, @PathVariable(name="id") Long id) {
		cl.setIdnivodacces(id);
		return nivodaccesRepository.save(cl);
	}
	
	@DeleteMapping("nivodaccesesx/{id}")
	public List<Nivodacces> deleteNivodacces(@PathVariable(name="id") Long id) {
		nivodaccesRepository.deleteById(id);			
			return nivodaccesRepository.findAll();
	}

}
