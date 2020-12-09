package com.group.touchefinale;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;


import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.group.touchefinale.dao.EntrepriseRepository;
import com.group.touchefinale.dao.NivodaccesRepository;
import com.group.touchefinale.dao.PostulantRepository;
import com.group.touchefinale.entities.Entreprise;
import com.group.touchefinale.entities.Nivodacces;
import com.group.touchefinale.entities.Postulant;

@SpringBootApplication
public class PlateformeRecrutementApplication implements CommandLineRunner{

	@Autowired
	private RepositoryRestConfiguration repoConfiguration;
	
	@Autowired
	private EntrepriseRepository entrepriseRepository;
	
	@Autowired
	private PostulantRepository postulantRepository;
	
	@Autowired
	private NivodaccesRepository nivodaccesRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(PlateformeRecrutementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		repoConfiguration.exposeIdsFor(Nivodacces.class);
		repoConfiguration.exposeIdsFor(Entreprise.class);
		repoConfiguration.exposeIdsFor(Postulant.class);
		
		
		/*
		 * nivodaccesRepository.save(new Nivodacces("Niveau 1"));
		 * nivodaccesRepository.save(new Nivodacces("Niveau 2"));
		 * nivodaccesRepository.save(new Nivodacces("Niveau 3"));
		 * nivodaccesRepository.save(new Nivodacces("Niveau 4"));
		 */
		  
		
		/*
		 * entrepriseRepository.save(new Entreprise("touchefinale4@gmail.com",
		 * "GTMprincess@@", "image.jpg", "sfax-ElOns", "glasgow", "Ecosse", new Date(),
		 * "Phydel", "SSII of Ivoiry Coast", "ToocheFinale"));
		 * 
		 * 
		 * entrepriseRepository.save(new Entreprise("fieni2fidel@gmail.com",
		 * "GTMprincess@@", "image.jpg", "sfax-ElOns", "Sfax", "Tunisie", new Date(),
		 * "Phydel", "SSII of Africa", "Orange"));
		 * 
		 * postulantRepository.save(new Postulant("toochefinale@gmail.com",
		 * "princessOfMyHeart", "MD.jpg", "CocodyRiviera4", "Abidjan", "Tunisie", new
		 * Date(), "fieni", "kobenan fidel", "masculin", new Date(),
		 * "M.","Celibataire"));
		 * 
		 * postulantRepository.save(new Postulant("angelique@gmail.com",
		 * "princessOfDoctor", "MD.jpg", "CocodyRiviera4", "Abidjan", "Tunisie", new
		 * Date(), "Konandri", "boris", "masculin", new Date(), "M.","Celibataire"));
		 */
				
	}
	
	
	  @Bean 
	  public BCryptPasswordEncoder getBCPE() 
	  	{ 
		  return new BCryptPasswordEncoder();
	  	}
	 

}
