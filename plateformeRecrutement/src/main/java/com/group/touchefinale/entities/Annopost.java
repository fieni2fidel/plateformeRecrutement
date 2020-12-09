package com.group.touchefinale.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Annopost {

	//@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idannopost;
		
	private String decisionannopost;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date datecreationannopost;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn
	private Annonce annonce;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn
	private Postulant postulant;

	public Annopost() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Annopost(String decisionannopost, Date datecreationannopost) {
		super();
		this.decisionannopost = decisionannopost;
		this.datecreationannopost = datecreationannopost;
	}



	public Long getIdannopost() {
		return idannopost;
	}

	public void setIdannopost(Long idannopost) {
		this.idannopost = idannopost;
	}

	
	public Annonce getAnnonce() {
		return annonce;
	}

	
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}

	public Postulant getPostulant() {
		return postulant;
	}

	public void setPostulant(Postulant postulant) {
		this.postulant = postulant;
	}


	public String getDecisionannopost() {
		return decisionannopost;
	}


	public void setDecisionannopost(String decisionannopost) {
		this.decisionannopost = decisionannopost;
	}


	public Date getDatecreationannopost() {
		return datecreationannopost;
	}


	public void setDatecreationannopost(Date datecreationannopost) {
		this.datecreationannopost = datecreationannopost;
	}
	
	
}