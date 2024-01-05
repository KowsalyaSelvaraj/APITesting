package com.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class JsonRawValuePOJO {

	
	private int id;
	private String nameString;
	private String emailString;
	
	@JsonRawValue
	private String skills1 = "java";
	@JsonRawValue
	private String skills2 = "{[\"java\"],[\"selenium\"]}";
	
	
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
	
	public String getSkills1() {
		return skills1;
	}
	public String getSkills2() {
		return skills2;
	}
	
	
}
