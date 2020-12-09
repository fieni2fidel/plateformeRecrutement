package com.group.touchefinale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.group.touchefinale.entities.Postulant;

@CrossOrigin("*")
@RepositoryRestResource
public interface PostulantRepository extends JpaRepository<Postulant, Long>{

}
