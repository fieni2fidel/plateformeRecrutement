package com.group.touchefinale.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.group.touchefinale.entities.Entreprise;
import com.group.touchefinale.entities.Utilisateur;

@CrossOrigin("*")
@RepositoryRestResource
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
	
	public Entreprise findByMailutilisateur(String mailutilisateur);
	 
	  @RestResource(path="/byNomEntreprise")
	  public List<Entreprise>findByNomentrepriseContains(@Param("x") String immo);
	  
	  @RestResource(path="/byNomEntreprisePage") 
	  public Page<Entreprise>findByNomentrepriseContains(@Param("x") String immo, Pageable page);
	 
}
