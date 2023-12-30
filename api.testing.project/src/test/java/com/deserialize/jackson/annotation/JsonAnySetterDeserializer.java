package com.deserialize.jackson.annotation;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonAnySetterDeserializer {

	@Test
	public void deserializeJson() throws JsonMappingException, JsonProcessingException {


		String jsonString = "{\r\n"
				+ "      \"first_name\": \"Naani\",\r\n"
				+ "      \"last_name\": \"Charan\",\r\n"
				+ "      \"email\": \"nanicharan@gmail.com\",\r\n"
				+ "      \"id\": 15\r\n"
				+ "    }";

		ObjectMapper mapper = new ObjectMapper();

		JsonAnySetterPOJO anySetterPOJO =  mapper.readValue(jsonString, JsonAnySetterPOJO.class);

		System.out.println(anySetterPOJO.getEmployeeMap());
	}
}
