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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Diplome implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long iddiplome;
	 
	 private String nomdiplome;
	  
	 @DateTimeFormat(pattern="yyyy-MM-dd")
	 private Date anneediplome;
	  
	@ManyToOne
	@NotFound(action = NotFoundAction.IGNORE)
	@JoinColumn
	private Postulant postulant;
	  
	 @OneToMany(fetch = FetchType.LAZY, mappedBy="diplome",cascade = CascadeType.ALL )
	 private Collection<Competence>competences;
	 
	 @OneToMany(fetch = FetchType.LAZY, mappedBy="diplome",cascade = CascadeType.ALL )
	 private Collection<Experienceprof>experienceprofs;

	public Diplome() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Diplome(String nomdiplome, Date anneediplome) {
		super();
		this.nomdiplome = nomdiplome;
		this.anneediplome = anneediplome;
	}

	public Long getIddiplome() {
		return iddiplome;
	}

	public void setIddiplome(Long iddiplome) {
		this.iddiplome = iddiplome;
	}

	public String getNomdiplome() {
		return nomdiplome;
	}

	public void setNomdiplome(String nomdiplome) {
		this.nomdiplome = nomdiplome;
	}

	public Date getAnneediplome() {
		return anneediplome;
	}

	public void setAnneediplome(Date anneediplome) {
		this.anneediplome = anneediplome;
	}

	public Postulant getPostulant() {
		return postulant;
	}

	public void setPostulant(Postulant postulant) {
		this.postulant = postulant;
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
