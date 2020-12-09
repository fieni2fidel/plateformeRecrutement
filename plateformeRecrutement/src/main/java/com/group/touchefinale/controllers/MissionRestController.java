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

import com.group.touchefinale.dao.MissionRepository;
import com.group.touchefinale.dao.NivodaccesRepository;
import com.group.touchefinale.entities.Mission;
import com.group.touchefinale.entities.Nivodacces;

@CrossOrigin("*")
@RestController
public class MissionRestController {

	@Autowired
	private MissionRepository missionRepository; 
	
	@GetMapping("/missionsx")
	public List<Mission> listeMission(){	
		List<Mission>cl=missionRepository.findAll();
		return cl;		
	}
	
	@GetMapping("/missionsx/{id}")
	public Mission listeMissionId(@PathVariable(name="id") Long id) {		
		//	Client clt=clientRepository.getOne(id);
		return missionRepository.findById(id).get();
	}
	
	
	@PostMapping("/missionsx")	
	public Mission saveMission(@RequestBody Mission cl) {
		
		return missionRepository.save(cl);
	}
	
	@PutMapping("/missionsx/{id}")
	public Mission updateMission(@RequestBody Mission cl, @PathVariable(name="id") Long id) {
		cl.setIdmission(id);
		return missionRepository.save(cl);
	}
	
	@DeleteMapping("missionsx/{id}")
	public List<Mission> deleteMission(@PathVariable(name="id") Long id) {
		missionRepository.deleteById(id);			
			return missionRepository.findAll();
	}

}
