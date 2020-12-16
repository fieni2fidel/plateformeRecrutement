package com.group.touchefinale.entities;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;

@Entity
@DiscriminatorValue("Postulant")
public class Postulant extends Utilisateur{

	
	private String nompostulant;
	private String prenompostulant;	
	private String sexepostulant;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date datedenaissancepostulant;
	
	private String civilitepostulant;
	private String situationmatrimonialepostulant;
	
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn
	private Currivitae currivitae;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="postulant",cascade = CascadeType.ALL )
	private Collection<Annopost>annoposts;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="postulant",cascade = CascadeType.ALL )
	private Collection<Diplome>diplomes;
	
	 @OneToMany(fetch = FetchType.LAZY, mappedBy="postulant",cascade = CascadeType.ALL )
	 private Collection<Competence>competences;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy="postulant",cascade = CascadeType.ALL )
	 private Collection<Experienceprof>experienceprofs;
	  
	  
	public Postulant() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Postulant(String mailutilisateur, String passwordutilisateur, String motsecret, String imageutilisateur,
			String adresseutilisateur, String villeutilisateur, String paysutilisateur, Date datecreationutilisateur,
			String nompostulant, String prenompostulant, String sexepostulant, Date datedenaissancepostulant,
			String civilitepostulant, String situationmatrimonialepostulant) {
		super(mailutilisateur, passwordutilisateur, motsecret, imageutilisateur, adresseutilisateur, villeutilisateur,
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


	public Currivitae getCurrivitae() {
		return currivitae;
	}


	public void setCurrivitae(Currivitae currivitae) {
		this.currivitae = currivitae;
	}


	public Collection<Diplome> getDiplomes() {
		return diplomes;
	}


	public void setDiplomes(Collection<Diplome> diplomes) {
		this.diplomes = diplomes;
	}


	public Collection<Competence> getCompetences() {
		return competences;
	}


	public void setCompetences(Collection<Competence> competences) {
		this.competences = competences;
	}


	public Collection<Experienceprof> getExperienceprofs() {
		return experienceprofs;
	}


	public void setExperienceprofs(Collection<Experienceprof> experienceprofs) {
		this.experienceprofs = experienceprofs;
	}

	
	
	  
}
