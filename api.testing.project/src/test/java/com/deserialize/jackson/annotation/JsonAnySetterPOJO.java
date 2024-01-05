package com.deserialize.jackson.annotation;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnySetter;

public class JsonAnySetterPOJO {

	
	private Map<String, Object> employeeMap = new HashMap<String,Object>();

	
	public Map<String, Object> getEmployeeMap() {
		return employeeMap;
	}

	@JsonAnySetter
	public void setEmployeeMap(String key,Object value) {
		employeeMap.put(key, value);
	}
	
	
}
