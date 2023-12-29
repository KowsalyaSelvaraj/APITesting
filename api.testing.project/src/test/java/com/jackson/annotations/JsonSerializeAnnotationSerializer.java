package com.jackson.annotations;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class JsonSerializeAnnotationSerializer {

	@Test
	public void serializeData() throws JsonProcessingException {
		
		
		JsonSerializePOJO serializePOJO = new JsonSerializePOJO();
		
		serializePOJO.setId(52);
		serializePOJO.setNameString("Laddu");
		serializePOJO.setEmailString("laddu@gmail.com");
		serializePOJO.setSkillStrings(Arrays.asList("Java","selenium"));
		
		JsonSerializeDevicesPOJO jsonSerializeDevicesPOJO = new JsonSerializeDevicesPOJO();
		jsonSerializeDevicesPOJO.setLaptopString("Dell");
		jsonSerializeDevicesPOJO.setMobileString("Iphone Pro Max");
		
		serializePOJO.setDevices(jsonSerializeDevicesPOJO);
		//serialize
		ObjectMapper mapper = new ObjectMapper();
		
		//when we use jsonserialize we can comment below 3 lines of code 
//		SimpleModule simpleModule = new SimpleModule();
//		
//		simpleModule.addSerializer(JsonSerializePOJO.class,new JsonSerializeCustomSerializer());
//		mapper.registerModule(simpleModule);
//		
		String jsonString =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(serializePOJO);
		
		System.out.println(jsonString);
	}
}

//o/p
//{
//	  "id" : 52,
//	  "nameString" : "Laddu",
//	  "emailString" : "laddu@gmail.com",
//	  "skillStrings" : [ "Java", "selenium" ],
//	  "devices" : {
//	    "laptopString" : "Dell",
//	    "mobileString" : "Iphone Pro Max"
//	  }
//	}


//After Custom Serialization
//{
//	  "first_Name" : "Laddu",
//	  "email_Id" : "laddu@gmail.com",
//	  "skills_List" : "[Java, selenium]"
//	}