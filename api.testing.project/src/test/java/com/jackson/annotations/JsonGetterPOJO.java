package com.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonGetter;

public class JsonGetterPOJO {

	
	private int id;
	private String nameString;
	private String emailString;
	
	@JsonGetter(value = "employeeId")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	
	
}
