package com.group.touchefinale.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.group.touchefinale.entities.Entreprise;


@CrossOrigin("*")
@RepositoryRestResource
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {
	
	  public Entreprise findByMailutilisateur(String mailutilisateur);
	 
	 
	  //public List<Entreprise>findAllByOrderByIdutilisateurDesc();
	  
	  
	  
	  @Query("select e from Entreprise e where "
	  		+ "e.nomdurecruteurentreprise like :x and e.nomentreprise like :y"
	  		+ " and e.villeutilisateur like :z and e.paysutilisateur like :w ")
	  public Page<Entreprise>entre(@Param("x") String x, @Param("y") String y, @Param("z") String z, @Param("w") String w, Pageable page);
	  
	  
	  
	  @RestResource(path="/byNomEntreprise")
	  public List<Entreprise>findByNomentrepriseContains(@Param("x") String x);
	  
	  @RestResource(path="/byNomEntreprisePage") 
	  public Page<Entreprise>findByNomentrepriseContains(@Param("x") String x, Pageable page);
	  
	  @RestResource(path="/byNomDuRecruteurEntreprisePage") 
	  public Page<Entreprise>findByNomdurecruteurentrepriseContainsOrderByIdutilisateurDesc(@Param("x") String x, Pageable page);
	  
	  @RestResource(path="/byNomEntrepriseAndNomdurecruteurentreprisePage") 
	  public Page<Entreprise>findByNomentrepriseAndNomdurecruteurentreprise(@Param("x") String x, @Param("y") String y, Pageable page);
	 
	  @RestResource(path="/byNomEntrepriseOrNomdurecruteurentreprisePage") 
	  public Page<Entreprise>
	  findByNomentrepriseOrNomdurecruteurentrepriseOrVilleutilisateurOrPaysutilisateur
	  (@Param("entreprise") String entreprise, @Param("recruteur") String recruteur, @Param("ville") String ville,
			  @Param("pays") String pays, Pageable page);
	 
}
