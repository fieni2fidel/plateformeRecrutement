package com.group.touchefinale.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.group.touchefinale.entities.Entreprise;
import com.group.touchefinale.entities.Postulant;

@CrossOrigin("*")
@RepositoryRestResource
public interface PostulantRepository extends JpaRepository<Postulant, Long>{
	
	 @Query("select e from Postulant e where "
		  		+ "e.nompostulant like :x and e.prenompostulant like :y"
		  		+ " and e.villeutilisateur like :z and e.paysutilisateur like :w ")
		  public Page<Postulant>postulan(@Param("x") String x, @Param("y") String y, @Param("z") String z, @Param("w") String w, Pageable page);
		  

}
