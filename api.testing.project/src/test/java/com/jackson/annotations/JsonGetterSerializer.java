package com.jackson.annotations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonGetterSerializer {

	@Test
	public void serializeData() throws JsonProcessingException {
		
		
		JsonGetterPOJO getterPOJO = new JsonGetterPOJO();
		
		getterPOJO.setId(52);
		getterPOJO.setNameString("Laddu");
		getterPOJO.setEmailString("laddu@gmail.com");
		
		//serialize
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getterPOJO);
		
		System.out.println(jsonString);
	}
}

//o/p
//{
//	  "nameString" : "Laddu",
//	  "emailString" : "laddu@gmail.com",
//	  "employeeId" : 52
//	}
