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
public class Autreinfo implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private Long idautreinfo;
	
	private String descriptionautreinfo;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn
	private Annonce annonce;

	public Autreinfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Autreinfo(String descriptionautreinfo) {
		super();
		this.descriptionautreinfo = descriptionautreinfo;
	}

	public Autreinfo(String descriptionautreinfo, Annonce annonce) {
		super();
		this.descriptionautreinfo = descriptionautreinfo;
		this.annonce = annonce;
	}

	public Long getIdautreinfo() {
		return idautreinfo;
	}

	public void setIdautreinfo(Long idautreinfo) {
		this.idautreinfo = idautreinfo;
	}

	public String getDescriptionautreinfo() {
		return descriptionautreinfo;
	}

	public void setDescriptionautreinfo(String descriptionautreinfo) {
		this.descriptionautreinfo = descriptionautreinfo;
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
