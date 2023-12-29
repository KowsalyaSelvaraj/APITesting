package com.jackson.annotations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonRootNameSerializer {

	@Test
	public void serializeData() throws JsonProcessingException {
		
		
		JsonRootNamePOJO rootNamePOJO = new JsonRootNamePOJO();
		
		rootNamePOJO.setId(52);
		rootNamePOJO.setNameString("Laddu");
		rootNamePOJO.setEmailString("laddu@gmail.com");
		
		//serialize
		ObjectMapper mapper = new ObjectMapper();
		
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		
		String jsonString =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rootNamePOJO);
		
		System.out.println(jsonString);
	}
}

//o/p
//{
//	  "employees" : {
//		    "id" : 52,
//		    "nameString" : "Laddu",
//		    "emailString" : "laddu@gmail.com"
//		  }
//		}
