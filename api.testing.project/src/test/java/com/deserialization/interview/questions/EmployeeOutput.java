package com.deserialization.interview.questions;

import java.util.List;

public class EmployeeOutput {

	private String firstNameString;
	private String lastNameString;
	private String emailIdString;
	private List<String> skillStrings;
	
	private int id;
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the firstNameString
	 */
	public String getFirstNameString() {
		return firstNameString;
	}
	/**
	 * @param firstNameString the firstNameString to set
	 */
	public void setFirstNameString(String firstNameString) {
		this.firstNameString = firstNameString;
	}
	/**
	 * @return the lastNameString
	 */
	public String getLastNameString() {
		return lastNameString;
	}
	/**
	 * @param lastNameString the lastNameString to set
	 */
	public void setLastNameString(String lastNameString) {
		this.lastNameString = lastNameString;
	}
	/**
	 * @return the emailIdString
	 */
	public String getEmailIdString() {
		return emailIdString;
	}
	/**
	 * @param emailIdString the emailIdString to set
	 */
	public void setEmailIdString(String emailIdString) {
		this.emailIdString = emailIdString;
	}
	/**
	 * @return the skillStrings
	 */
	public List<String> getSkillStrings() {
		return skillStrings;
	}
	/**
	 * @param skillStrings the skillStrings to set
	 */
	public void setSkillStrings(List<String> skillStrings) {
		this.skillStrings = skillStrings;
	}
	
	
}
