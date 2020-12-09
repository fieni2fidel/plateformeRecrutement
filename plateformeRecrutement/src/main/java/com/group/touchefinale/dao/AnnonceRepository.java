package com.group.touchefinale.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.group.touchefinale.entities.Annonce;

@CrossOrigin("*")
@RepositoryRestResource
public interface AnnonceRepository extends JpaRepository<Annonce, Long>{
	
	/*
	 * @Query("select e from Evenement e where e.datedebutevenement >= :x")
	 * List<Annonce> findAll(Date x);
	 */
	
	/*
	 * @Query("select e from Annonce e where e.utilisateur.idutilisateur = :x")
	 * public List<Annonce>findAnnonceWithUtilisateur(Long id);
	 */
	  
	  @Query("select e from Annonce e where e.entreprise.idutilisateur = :idutilisateur")
	  public List<Annonce>findByIdentreprise(Long idutilisateur);
	  
	  
	  @Query("select e from Annonce e where e.entreprise.mailutilisateur = :mailutilisateur")
	  public List<Annonce>findByMailentreprise(String mailutilisateur);
	 

}
