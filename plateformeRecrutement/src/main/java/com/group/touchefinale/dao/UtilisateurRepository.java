package com.group.touchefinale.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.group.touchefinale.entities.Utilisateur;

@CrossOrigin("*")
@RepositoryRestResource
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

	public Utilisateur findByMailutilisateur(String mailutilisateur);
	
	 @Query("select e from Utilisateur e where e.mailutilisateur = :x")
	 public List<Utilisateur> findAll(String x);

}
