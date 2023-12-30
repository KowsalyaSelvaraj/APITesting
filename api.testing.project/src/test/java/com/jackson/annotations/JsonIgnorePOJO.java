package com.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;


//@JsonIgnoreProperties({"age","emailString"})
//@JsonInclude(Include.NON_NULL)
@JsonInclude(Include.NON_DEFAULT)

public class JsonIgnorePOJO {

	
	private int id;
	private String nameString;
	@JsonIgnore
	private String emailString;
	private String skillString = "Java, Python";
	private int age;
	private String IsGood;
	
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
	public String getSkillString() {
		return skillString;
	}
	public void setSkillString(String skillString) {
		this.skillString = skillString;
	}
	public String isIsGood() {
		return IsGood;
	}
	public void setIsGood(String isGood) {
		IsGood = isGood;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
