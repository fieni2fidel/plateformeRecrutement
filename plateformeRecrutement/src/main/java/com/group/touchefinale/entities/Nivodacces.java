package com.group.touchefinale.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Nivodacces implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idnivodacces;
	
	private String nomnivodacces;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="nivodacces",cascade = CascadeType.ALL )
	private Collection<Utilisateur>utilisateurs;
	
	
	public Nivodacces() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Nivodacces(String nomnivodacces) {
		super();
		this.nomnivodacces = nomnivodacces;
	}
	
	


	public Nivodacces(Long idnivodacces) {
		super();
		this.idnivodacces = idnivodacces;
	}


	@JsonIgnore
	public Collection<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}


	@JsonSetter
	public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}


	public Long getIdnivodacces() {
		return idnivodacces;
	}

	public void setIdnivodacces(Long idnivodacces) {
		this.idnivodacces = idnivodacces;
	}

	public String getNomnivodacces() {
		return nomnivodacces;
	}

	public void setNomnivodacces(String nomnivodacces) {
		this.nomnivodacces = nomnivodacces;
	}
	

}
