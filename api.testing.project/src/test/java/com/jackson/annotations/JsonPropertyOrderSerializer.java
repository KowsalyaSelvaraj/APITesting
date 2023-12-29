package com.jackson.annotations;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonPropertyOrderSerializer {

	@Test
	public void serializeData() throws JsonProcessingException {
		
		
		JsonPropertyOrderPOJO propertyOrderPOJO = new JsonPropertyOrderPOJO();
		
		propertyOrderPOJO.setId(52);
		propertyOrderPOJO.setNameString("Laddu");
		propertyOrderPOJO.setEmailString("laddu@gmail.com");
		
		//serialize
		ObjectMapper mapper = new ObjectMapper();
		
		String jsonString =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(propertyOrderPOJO);
		
		System.out.println(jsonString);
	}
}

//o/p
//{
//"AId" : 52,
//"BEmail" : "laddu@gmail.com",
//"CName" : "Laddu"
//}
