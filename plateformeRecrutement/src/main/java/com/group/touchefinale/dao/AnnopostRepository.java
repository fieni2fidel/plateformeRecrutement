package com.group.touchefinale.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.group.touchefinale.entities.Annopost;
import com.group.touchefinale.entities.Entreprise;

@CrossOrigin("*")
@RepositoryRestResource
public interface AnnopostRepository extends JpaRepository<Annopost, Long>{
	
	public Annopost findByIdannopost(Long idannopost);
	
	  @Query("select e from Annopost e where e.postulant.idutilisateur= :idutilisateur ") 
	  public List<Annopost> findByIdpostulant(Long idutilisateur);
	 
	
	
	  @Query("select e from Annopost e where e.annonce.idannonce= :idannonce ")
	  public List<Annopost> findByIdannonce(Long idannonce);
	 
	
	@Query("select e from Annopost e where e.annonce.entreprise.idutilisateur= :idutilisateur ")
	public List<Annopost> findByIdentreprise(Long idutilisateur);
	

}
