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

@Entity
public class Competence implements Serializable{
		
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idcompetence;
	  
		private String nomcompetence;
		  
		@ManyToOne
		@NotFound(action = NotFoundAction.IGNORE)
		@JoinColumn
		private Diplome diplome;

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

		public Diplome getDiplome() {
			return diplome;
		}

		public void setDiplome(Diplome diplome) {
			this.diplome = diplome;
		}
		
		

}
