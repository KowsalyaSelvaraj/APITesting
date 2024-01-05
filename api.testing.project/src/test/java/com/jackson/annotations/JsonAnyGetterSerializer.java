package com.jackson.annotations;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAnyGetterSerializer {

	@Test
	public void serializeData() throws JsonProcessingException {
		
		
		JsonAnyGetterPOJO anyGetterPOJO = new JsonAnyGetterPOJO();
		
		Map<String,Object> mapValues = new HashMap<String,Object>();
		
		mapValues.put("firstName", "Ram");
		mapValues.put("lastName", "Charan");
		
		mapValues.put("email", "ramcharan@gmail.com");
		
		mapValues.put("skills", Arrays.asList("Java","Python","Selenium"));
		
		
		anyGetterPOJO.setEmployeePropertiesMap(mapValues);
		
		//serialize
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(anyGetterPOJO);
		
		System.out.println(jsonString);
	}
}

//o/p with annotation
//{
//	  "skills" : [ "Java", "Python", "Selenium" ],
//	  "firstName" : "Ram",
//	  "lastName" : "Charan",
//	  "email" : "ramcharan@gmail.com"
//	}

//o/p without annotation
//
//{
//	  "employeePropertiesMap" : {
//	    "skills" : [ "Java", "Python", "Selenium" ],
//	    "firstName" : "Ram",
//	    "lastName" : "Charan",
//	    "email" : "ramcharan@gmail.com"
//	  }
//	}
