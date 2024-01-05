package com.deserialize.jackson.annotation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAliasDeserializer {

	@Test
	public void deserializeJson() throws JsonMappingException, JsonProcessingException {


		String jsonString = "{\r\n"
				+ "      \"first_name\": \"Naani\",\r\n"
				+ "      \"last_name\": \"Charan\",\r\n"
				+ "      \"email\": \"nanicharan@gmail.com\",\r\n"
				+ "      \"empID\": 18\r\n"
				+ "    }";

		ObjectMapper mapper = new ObjectMapper();

		JsonAliasPOJO aliasPOJO =  mapper.readValue(jsonString, JsonAliasPOJO.class);

		System.out.println(aliasPOJO.getId());
		System.out.println(aliasPOJO.getEmail());
		System.out.println(aliasPOJO.getFirst_name());
		System.out.println(aliasPOJO.getLast_name());
	}
}

//o/p
//18
//nanicharan@gmail.com
//Naani
//Charan