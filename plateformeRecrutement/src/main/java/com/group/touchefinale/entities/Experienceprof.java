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
public class Experienceprof implements Serializable{

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long idexperienceprof;
	  
		private String periodeexperienceprof;
		private String societeexperienceprof;
		private String fonctionexperienceprof;
	  
		@ManyToOne
		@NotFound(action = NotFoundAction.IGNORE)
		@JoinColumn
		private Diplome diplome;

		public Experienceprof() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Experienceprof(String periodeexperienceprof, String societeexperienceprof,
				String fonctionexperienceprof) {
			super();
			this.periodeexperienceprof = periodeexperienceprof;
			this.societeexperienceprof = societeexperienceprof;
			this.fonctionexperienceprof = fonctionexperienceprof;
		}

		public Long getIdexperienceprof() {
			return idexperienceprof;
		}

		public void setIdexperienceprof(Long idexperienceprof) {
			this.idexperienceprof = idexperienceprof;
		}

		public String getPeriodeexperienceprof() {
			return periodeexperienceprof;
		}

		public void setPeriodeexperienceprof(String periodeexperienceprof) {
			this.periodeexperienceprof = periodeexperienceprof;
		}

		public String getSocieteexperienceprof() {
			return societeexperienceprof;
		}

		public void setSocieteexperienceprof(String societeexperienceprof) {
			this.societeexperienceprof = societeexperienceprof;
		}

		public String getFonctionexperienceprof() {
			return fonctionexperienceprof;
		}

		public void setFonctionexperienceprof(String fonctionexperienceprof) {
			this.fonctionexperienceprof = fonctionexperienceprof;
		}

		public Diplome getDiplome() {
			return diplome;
		}

		public void setDiplome(Diplome diplome) {
			this.diplome = diplome;
		}
		
		
		
		
}
