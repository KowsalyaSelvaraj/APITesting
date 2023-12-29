package com.workwith.jsonfile;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class EmployeePOJO {

	
	private String first_name;
	private String last_name;
	private String email;
	
	private List<String> skills;

	@Getter
	@Setter
	private String toCheckLombokString;
	
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}
	
	
}
