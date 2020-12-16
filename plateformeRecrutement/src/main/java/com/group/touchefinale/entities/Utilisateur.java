package com.group.touchefinale.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeutilisateur",discriminatorType = DiscriminatorType.STRING,length = 20)
public abstract class Utilisateur implements Serializable{

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long idutilisateur;
		
	@Column(unique = true)
	private String mailutilisateur;
	
	private String passwordutilisateur;
	
	private String motsecret;
	
	private String imageutilisateur;
	
	private String adresseutilisateur;
	
	private String villeutilisateur;
	
	private String paysutilisateur; 
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date datecreationutilisateur;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn 
	private Nivodacces nivodacces;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn 
	private Entreprise entreprise;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn 
	private Postulant postulant;


	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Utilisateur(String mailutilisateur, String passwordutilisateur, String motsecret ,String imageutilisateur,
			String adresseutilisateur, String villeutilisateur, String paysutilisateur, Date datecreationutilisateur) {
		super();
		this.mailutilisateur = mailutilisateur;
		this.passwordutilisateur = passwordutilisateur;
		this.motsecret = motsecret;
		this.imageutilisateur = imageutilisateur;
		this.adresseutilisateur = adresseutilisateur;
		this.villeutilisateur = villeutilisateur;
		this.paysutilisateur = paysutilisateur;
		this.datecreationutilisateur = datecreationutilisateur;
	}

	public Nivodacces getNivodacces() {
		return nivodacces;
	}

	public void setNivodacces(Nivodacces nivodacces) {
		this.nivodacces = nivodacces;
	}


	public Long getIdutilisateur() {
		return idutilisateur;
	}


	public void setIdutilisateur(Long idutilisateur) {
		this.idutilisateur = idutilisateur;
	}


	public String getMailutilisateur() {
		return mailutilisateur;
	}


	public void setMailutilisateur(String mailutilisateur) {
		this.mailutilisateur = mailutilisateur;
	}


	public String getPasswordutilisateur() {
		return passwordutilisateur;
	}


	public void setPasswordutilisateur(String passwordutilisateur) {
		this.passwordutilisateur = passwordutilisateur;
	}
	
	
	public String getMotsecret() {
		return motsecret;
	}


	public void setMotsecret(String motsecret) {
		this.motsecret = motsecret;
	}


	public String getImageutilisateur() {
		return imageutilisateur;
	}


	public void setImageutilisateur(String imageutilisateur) {
		this.imageutilisateur = imageutilisateur;
	}


	public String getAdresseutilisateur() {
		return adresseutilisateur;
	}


	public void setAdresseutilisateur(String adresseutilisateur) {
		this.adresseutilisateur = adresseutilisateur;
	}


	public String getVilleutilisateur() {
		return villeutilisateur;
	}


	public void setVilleutilisateur(String villeutilisateur) {
		this.villeutilisateur = villeutilisateur;
	}


	public String getPaysutilisateur() {
		return paysutilisateur;
	}


	public void setPaysutilisateur(String paysutilisateur) {
		this.paysutilisateur = paysutilisateur;
	}


	public Date getDatecreationutilisateur() {
		return datecreationutilisateur;
	}


	public void setDatecreationutilisateur(Date datecreationutilisateur) {
		this.datecreationutilisateur = datecreationutilisateur;
	}



	@JsonIgnore
	public Entreprise getEntreprise() {
		return entreprise;
	}


	public void setEntreprise(Entreprise entreprise) {
		this.entreprise = entreprise;
	}


	@JsonIgnore
	public Postulant getPostulant() {
		return postulant;
	}


	public void setPostulant(Postulant postulant) {
		this.postulant = postulant;
	}
	
	
}
