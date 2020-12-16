package com.group.touchefinale.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@DiscriminatorValue("Entreprise")
public class Entreprise extends Utilisateur{
	
	private String nomdurecruteurentreprise; 
	
	private String descriptionentreprise;
	
	private String nomentreprise;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="entreprise",cascade = CascadeType.ALL )
	private Collection<Annonce>annonces;
	


	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entreprise(String mailutilisateur, String passwordutilisateur, String motsecret, String imageutilisateur,
			String adresseutilisateur, String villeutilisateur, String paysutilisateur, Date datecreationutilisateur,
			String nomdurecruteurentreprise, String descriptionentreprise, String nomentreprise) {
		super(mailutilisateur, passwordutilisateur, motsecret, imageutilisateur, adresseutilisateur, villeutilisateur,
				paysutilisateur, datecreationutilisateur);
		this.nomdurecruteurentreprise = nomdurecruteurentreprise;
		this.descriptionentreprise = descriptionentreprise;
		this.nomentreprise = nomentreprise;
	}


	public String getNomdurecruteurentreprise() {
		return nomdurecruteurentreprise;
	}

	public void setNomdurecruteurentreprise(String nomdurecruteurentreprise) {
		this.nomdurecruteurentreprise = nomdurecruteurentreprise;
	}

	public String getDescriptionentreprise() {
		return descriptionentreprise;
	}

	public void setDescriptionentreprise(String descriptionentreprise) {
		this.descriptionentreprise = descriptionentreprise;
	}


	public String getNomentreprise() {
		return nomentreprise;
	}


	public void setNomentreprise(String nomentreprise) {
		this.nomentreprise = nomentreprise;
	}


	@JsonIgnore
	public Collection<Annonce> getAnnonces() {
		return annonces;
	}


	@JsonSetter
	public void setAnnonces(Collection<Annonce> annonces) {
		this.annonces = annonces;
	}
	
	
	
	
			
}
