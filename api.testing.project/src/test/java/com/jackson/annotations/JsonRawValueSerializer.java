package com.jackson.annotations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonRawValueSerializer {

	@Test
	public void serializeData() throws JsonProcessingException {
		
		
		JsonRawValuePOJO rawValuePOJO = new JsonRawValuePOJO();
		
		rawValuePOJO.setId(52);
		rawValuePOJO.setNameString("Laddu");
		rawValuePOJO.setEmailString("laddu@gmail.com");
		
		//serialize
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rawValuePOJO);
		
		System.out.println(jsonString);
	}
}

//o/p
//{
//	  "id" : 52,
//	  "nameString" : "Laddu",
//	  "emailString" : "laddu@gmail.com",
//	  "skills1" : java,
//	  "skills2" : {["java"],["selenium"]}
//	}