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
public class Competence implements Serializable{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idcompetence;
	  
		private String nomcompetence;
		  
		@ManyToOne
		@NotFound(action = NotFoundAction.IGNORE)
		@JoinColumn
		private Postulant postulant;

		public Competence() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Competence(String nomcompetence) {
			super();
			this.nomcompetence = nomcompetence;
		}

		public Long getIdcompetence() {
			return idcompetence;
		}

		public void setIdcompetence(Long idcompetence) {
			this.idcompetence = idcompetence;
		}

		public String getNomcompetence() {
			return nomcompetence;
		}

		public void setNomcompetence(String nomcompetence) {
			this.nomcompetence = nomcompetence;
		}

		@JsonIgnore
		public Postulant getPostulant() {
			return postulant;
		}

		@JsonSetter
		public void setPostulant(Postulant postulant) {
			this.postulant = postulant;
		}

	/*
	 * @JsonIgnore public Diplome getDiplome() { return diplome; }
	 * 
	 * @JsonSetter public void setDiplome(Diplome diplome) { this.diplome = diplome;
	 * }
	 */
		
		
		
	
		
		

}
