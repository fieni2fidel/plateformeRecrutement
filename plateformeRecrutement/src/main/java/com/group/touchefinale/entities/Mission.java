package com.group.touchefinale.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Mission implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idmission;
	
	private String descriptionmission;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn 
	private Annonce annonce;

	public Mission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Mission(String descriptionmission) {
		super();
		this.descriptionmission = descriptionmission;
	}

	public Mission(String descriptionmission, Annonce annonce) {
		super();
		this.descriptionmission = descriptionmission;
		this.annonce = annonce;
	}

	public Long getIdmission() {
		return idmission;
	}

	public void setIdmission(Long idmission) {
		this.idmission = idmission;
	}

	public String getDescriptionmission() {
		return descriptionmission;
	}

	public void setDescriptionmission(String descriptionmission) {
		this.descriptionmission = descriptionmission;
	}

	@JsonIgnore
	public Annonce getAnnonce() {
		return annonce;
	}

	@JsonSetter
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	
	
	
}
