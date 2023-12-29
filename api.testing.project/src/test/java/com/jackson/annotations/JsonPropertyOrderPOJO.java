package com.jackson.annotations;


import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//@JsonPropertyOrder({"id","nameString","emailString"})

@JsonPropertyOrder(alphabetic = true)
public class JsonPropertyOrderPOJO {

	
	private int id;
	private String nameString;
	private String emailString;
	
	@JsonGetter(value = "AId")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonGetter(value = "CName")
	public String getNameString() {
		return nameString;
	}
	public void setNameString(String nameString) {
		this.nameString = nameString;
	}
	
	@JsonGetter(value = "BEmail")
	public String getEmailString() {
		return emailString;
	}
	public void setEmailString(String emailString) {
		this.emailString = emailString;
	}
	
	
}
