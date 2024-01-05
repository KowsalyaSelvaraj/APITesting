package com.jackson.annotations;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = JsonSerializeCustomSerializer.class)
public class JsonSerializePOJO {

	
	private int id;
	private String nameString;
	private String emailString;
	private List<String> skillStrings;
	
	private JsonSerializeDevicesPOJO jsonSerializeDevicesPOJO;
	
	

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
	public List<String> getSkillStrings() {
		return skillStrings;
	}
	public void setSkillStrings(List<String> skillStrings) {
		this.skillStrings = skillStrings;
	}
	public JsonSerializeDevicesPOJO getDevices() {
		return jsonSerializeDevicesPOJO;
	}
	public void setDevices(JsonSerializeDevicesPOJO jsonSerializeDevicesPOJO) {
		this.jsonSerializeDevicesPOJO = jsonSerializeDevicesPOJO;
	}
	
	
}
