package com.deserialize.jackson.annotation;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

public class JsonCreatorPOJO {

	
	private int id;
	private String first_name;
	private String last_name;
	private String email;
	
	@JsonCreator
	public JsonCreatorPOJO(
			
			@JsonProperty("employeeId")
			int id,
			
			@JsonProperty("first_name")
			String first_name,
			
			@JsonProperty("last_name")
			String last_name,
			
			@JsonProperty("email")
			String email
			
			) {
		this.id = id;
		this.first_name = first_name;
		this.last_name  = last_name;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
		
	public String getFirst_name() {
		return first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}
	
	public String getEmail() {
		return email;
	}
		
}
