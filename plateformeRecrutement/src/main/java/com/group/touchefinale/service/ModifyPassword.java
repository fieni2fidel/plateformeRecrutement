package com.group.touchefinale.service;


public class ModifyPassword {

	private String mail;
	
	private String oldpassword;
	
	private String newpassword;

	public ModifyPassword() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public ModifyPassword(String mail, String oldpassword, String newpassword) {
		super();
		this.mail = mail;
		this.oldpassword = oldpassword;
		this.newpassword = newpassword;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	
	
}
