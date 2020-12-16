package com.group.touchefinale.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.group.touchefinale.entities.Currivitae;

@CrossOrigin("*")
@RepositoryRestResource
public interface CurrivitaeRepository extends JpaRepository<Currivitae, Long>{

}
