package com.deserialize.jackson.annotation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCreatorDeserializer {

	@Test
	public void deserializeJson() throws JsonMappingException, JsonProcessingException {


		String jsonString = "{\r\n"
				+ "      \"first_name\": \"Naani\",\r\n"
				+ "      \"last_name\": \"Charan\",\r\n"
				+ "      \"email\": \"nanicharan@gmail.com\",\r\n"
				+ "      \"employeeId\": 15\r\n"
				+ "    }";

		ObjectMapper mapper = new ObjectMapper();

		JsonCreatorPOJO creatorPOJO =  mapper.readValue(jsonString, JsonCreatorPOJO.class);

		System.out.println(creatorPOJO.getId());
		System.out.println(creatorPOJO.getEmail());
		System.out.println(creatorPOJO.getFirst_name());
		System.out.println(creatorPOJO.getLast_name());
	}
}

//o/p
//15
//nanicharan@gmail.com
//Naani
//Charan