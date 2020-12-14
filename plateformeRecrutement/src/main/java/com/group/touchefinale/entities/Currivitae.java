package com.group.touchefinale.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currivitae implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idcurrivitae;
	
	
	private String cvcurrivitae;


	public Currivitae() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Currivitae(String cvcurrivitae) {
		super();
		this.cvcurrivitae = cvcurrivitae;
	}


	public Long getIdcurrivitae() {
		return idcurrivitae;
	}


	public void setIdcurrivitae(Long idcurrivitae) {
		this.idcurrivitae = idcurrivitae;
	}


	public String getCvcurrivitae() {
		return cvcurrivitae;
	}


	public void setCvcurrivitae(String cvcurrivitae) {
		this.cvcurrivitae = cvcurrivitae;
	}
	
	

}
