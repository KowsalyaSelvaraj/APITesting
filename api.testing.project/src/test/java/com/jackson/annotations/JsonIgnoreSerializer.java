package com.jackson.annotations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnoreSerializer {

	@Test
	public void serializeData() throws JsonProcessingException {
		
		
		JsonIgnorePOJO ignorePOJO = new JsonIgnorePOJO();
		
		ignorePOJO.setId(52);
		ignorePOJO.setNameString("Laddu");
		ignorePOJO.setEmailString("laddu@gmail.com");
		ignorePOJO.setSkillString("Java");
		//serialize
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ignorePOJO);
		
		System.out.println(jsonString);
	}
}

//o/p -> Email has been ignored 
//{
//	  "nameString" : "Laddu",
//	  "skillString" : "Java",
//	  "employeeId" : 52
//	}