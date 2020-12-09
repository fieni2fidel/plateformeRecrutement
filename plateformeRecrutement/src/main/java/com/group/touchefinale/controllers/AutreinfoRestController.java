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

import com.group.touchefinale.dao.AutreinfoRepository;
import com.group.touchefinale.dao.NivodaccesRepository;
import com.group.touchefinale.entities.Autreinfo;
import com.group.touchefinale.entities.Mission;
import com.group.touchefinale.entities.Nivodacces;

@CrossOrigin("*")
@RestController
public class AutreinfoRestController {

	@Autowired
	private AutreinfoRepository autreinfoRepository;
	
	@GetMapping("/autreinfosx")
	public List<Autreinfo> listeAutreinfo(){	
		List<Autreinfo>cl=autreinfoRepository.findAll();
		return cl;		
	}
	
	@GetMapping("/autreinfosx/{id}")
	public Autreinfo listeAutreinfoId(@PathVariable(name="id") Long id) {		
		//	Client clt=clientRepository.getOne(id);
		return autreinfoRepository.findById(id).get();
	}
	
	
	@PostMapping("/autreinfosx")	
	public Autreinfo saveAutreinfo(@RequestBody Autreinfo cl) {
		
		return autreinfoRepository.save(cl);
	}
	
	@PutMapping("/autreinfosx/{id}")
	public Autreinfo updateAutreinfo(@RequestBody Autreinfo cl, @PathVariable(name="id") Long id) {
		cl.setIdautreinfo(id);
		return autreinfoRepository.save(cl);
	}
	
	@DeleteMapping("autreinfosx/{id}")
	public List<Autreinfo> deleteAutreinfo(@PathVariable(name="id") Long id) {
		autreinfoRepository.deleteById(id);			
			return autreinfoRepository.findAll();
	}

}
