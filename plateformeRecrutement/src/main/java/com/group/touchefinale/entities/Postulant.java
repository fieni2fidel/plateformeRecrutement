package com.group.touchefinale.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@DiscriminatorValue("Postulant")
public class Postulant extends Utilisateur{

	
	private String nompostulant;
	private String prenompostulant;
	private String sexepostulant;
	private Date datedenaissancepostulant;
	private String civilitepostulant;
	private String situationmatrimonialepostulant;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="annonce",cascade = CascadeType.ALL )
	private Collection<Annopost>annoposts;
	  
	  
	public Postulant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Postulant(String mailutilisateur, String passwordutilisateur, String imageutilisateur,
			String adresseutilisateur, String villeutilisateur, String paysutilisateur, Date datecreationutilisateur,
			String nompostulant, String prenompostulant, String sexepostulant, Date datedenaissancepostulant,
			String civilitepostulant, String situationmatrimonialepostulant) {
		super(mailutilisateur, passwordutilisateur, imageutilisateur, adresseutilisateur, villeutilisateur,
				paysutilisateur, datecreationutilisateur);
		this.nompostulant = nompostulant;
		this.prenompostulant = prenompostulant;
		this.sexepostulant = sexepostulant;
		this.datedenaissancepostulant = datedenaissancepostulant;
		this.civilitepostulant = civilitepostulant;
		this.situationmatrimonialepostulant = situationmatrimonialepostulant;
	}



	public String getNompostulant() {
		return nompostulant;
	}


	public void setNompostulant(String nompostulant) {
		this.nompostulant = nompostulant;
	}


	public String getPrenompostulant() {
		return prenompostulant;
	}


	public void setPrenompostulant(String prenompostulant) {
		this.prenompostulant = prenompostulant;
	}


	public String getSexepostulant() {
		return sexepostulant;
	}


	public void setSexepostulant(String sexepostulant) {
		this.sexepostulant = sexepostulant;
	}


	public Date getDatedenaissancepostulant() {
		return datedenaissancepostulant;
	}


	public void setDatedenaissancepostulant(Date datedenaissancepostulant) {
		this.datedenaissancepostulant = datedenaissancepostulant;
	}


	public String getCivilitepostulant() {
		return civilitepostulant;
	}


	public void setCivilitepostulant(String civilitepostulant) {
		this.civilitepostulant = civilitepostulant;
	}


	public String getSituationmatrimonialepostulant() {
		return situationmatrimonialepostulant;
	}


	public void setSituationmatrimonialepostulant(String situationmatrimonialepostulant) {
		this.situationmatrimonialepostulant = situationmatrimonialepostulant;
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
