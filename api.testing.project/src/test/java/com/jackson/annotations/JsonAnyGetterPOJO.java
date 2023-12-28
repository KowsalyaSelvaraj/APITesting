package com.jackson.annotations;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

public class JsonAnyGetterPOJO {

	
	private Map<String,Object> employeePropertiesMap;

	//@JsonAnyGetter
	public Map<String,Object> getEmployeePropertiesMap() {
		return employeePropertiesMap;
	}

	public void setEmployeePropertiesMap(Map<String,Object> employeePropertiesMap) {
		this.employeePropertiesMap = employeePropertiesMap;
	}
	
	
}
