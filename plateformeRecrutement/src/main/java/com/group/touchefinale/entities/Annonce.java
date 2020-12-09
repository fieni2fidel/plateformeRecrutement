package com.group.touchefinale.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
public class Annonce implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idannonce;
	
	private String nomannonce;
	private String descriptionannonce;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date datelimiteannonce;
	
	private String experienceannonce;
	private String salaireannonce;
	private String niveaurequisannonce;
	private String secteurannonce;
	private String typedecontratannonce;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date datecreationannonce;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn
	private Entreprise entreprise;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="annonce",cascade = CascadeType.ALL )
	private Collection<Mission>missions;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="annonce",cascade = CascadeType.ALL )
	private Collection<Autreinfo>autreinfos;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="annonce",cascade = CascadeType.ALL )
	private Collection<Annopost>annoposts;

	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Annonce(String nomannonce, String descriptionannonce, Date datelimiteannonce, String experienceannonce,
			String salaireannonce, String niveaurequisannonce, String secteurannonce, String typedecontratannonce,
			Date datecreationannonce) {
		super();
		this.nomannonce = nomannonce;
		this.descriptionannonce = descriptionannonce;
		this.datelimiteannonce = datelimiteannonce;
		this.experienceannonce = experienceannonce;
		this.salaireannonce = salaireannonce;
		this.niveaurequisannonce = niveaurequisannonce;
		this.secteurannonce = secteurannonce;
		this.typedecontratannonce = typedecontratannonce;
		this.datecreationannonce = datecreationannonce;
	}


	public Long getIdannonce() {
		return idannonce;
	}

	public void setIdannonce(Long idannonce) {
		this.idannonce = idannonce;
	}

	public String getNomannonce() {
		return nomannonce;
	}

	public void setNomannonce(String nomannonce) {
		this.nomannonce = nomannonce;
	}

	public String getDescriptionannonce() {
		return descriptionannonce;
	}

	public void setDescriptionannonce(String descriptionannonce) {
		this.descriptionannonce = descriptionannonce;
	}

	public Date getDatelimiteannonce() {
		return datelimiteannonce;
	}

	public void setDatelimiteannonce(Date datelimiteannonce) {
		this.datelimiteannonce = datelimiteannonce;
	}

	public String getExperienceannonce() {
		return experienceannonce;
	}

	public void setExperienceannonce(String experienceannonce) {
		this.experienceannonce = experienceannonce;
	}

	public String getSalaireannonce() {
		return salaireannonce;
	}

	public void setSalaireannonce(String salaireannonce) {
		this.salaireannonce = salaireannonce;
	}

	public String getNiveaurequisannonce() {
		return niveaurequisannonce;
	}

	public void setNiveaurequisannonce(String niveaurequisannonce) {
		this.niveaurequisannonce = niveaurequisannonce;
	}

	public String getSecteurannonce() {
		return secteurannonce;
	}

	public void setSecteurannonce(String secteurannonce) {
		this.secteurannonce = secteurannonce;
	}

	public String getTypedecontratannonce() {
		return typedecontratannonce;
	}

	public void setTypedecontratannonce(String typedecontratannonce) {
		this.typedecontratannonce = typedecontratannonce;
	}

	public Date getDatecreationannonce() {
		return datecreationannonce;
	}

	public void setDatecreationannonce(Date datecreationannonce) {
		this.datecreationannonce = datecreationannonce;
	}

	public Entreprise getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}

	public Collection<Mission> getMissions() {
		return missions;
	}

	public void setMissions(Collection<Mission> missions) {
		this.missions = missions;
	}

	public Collection<Autreinfo> getAutreinfos() {
		return autreinfos;
	}

	public void setAutreinfos(Collection<Autreinfo> autreinfos) {
		this.autreinfos = autreinfos;
	}

	@JsonIgnore
	public Collection<Annopost> getAnnoposts() {
		return annoposts;
	}

	@JsonSetter
	public void setAnnoposts(Collection<Annopost> annoposts) {
		this.annoposts = annoposts;
	}


	

	
	
	
}
