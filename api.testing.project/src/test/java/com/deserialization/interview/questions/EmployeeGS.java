package com.deserialization.interview.questions;

import java.util.List;

public class EmployeeGS {

	private String firstNameString;
	private String lastNameString;
	private String emailIdString;
	private List<String> skillStrings;
	
	public String getFirstNameString() {
		System.out.println("Getters "+firstNameString);
		return firstNameString;
	}
	public void setFirstNameString(String firstNameString) {
		System.out.println("Setters "+firstNameString);
		this.firstNameString = firstNameString;
	}
	public String getLastNameString() {
		System.out.println("Getters "+lastNameString);
		return lastNameString;
	}
	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
		System.out.println("Setters "+lastNameString);
	}
	public String getEmailIdString() {
		System.out.println("Getters "+emailIdString);
		return emailIdString;
	}
	public void setEmailIdString(String emailIdString) {
		this.emailIdString = emailIdString;
		System.out.println("Setters "+emailIdString);
	}
	public List<String> getSkillStrings() {
		System.out.println("Getters "+skillStrings);
		return skillStrings;
	}
	public void setSkillStrings(List<String> skillStrings) {
		this.skillStrings = skillStrings;
		System.out.println("Setters "+skillStrings);
	}
	
	
	
}
