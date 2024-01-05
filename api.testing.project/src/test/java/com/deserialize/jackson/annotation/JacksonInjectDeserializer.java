package com.deserialize.jackson.annotation;

import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

public class JacksonInjectDeserializer {

	@Test
	public void deserializeJson() throws IOException {


		String jsonString = "{\r\n"
				+ "      \"last_name\": \"Charan\",\r\n"
				+ "      \"email\": \"nanicharan@gmail.com\",\r\n"
				+ "      \"id\": 15\r\n"
				+ "    }";

		InjectableValues values = new InjectableValues.Std()
				.addValue(String.class, "Agni");

		ObjectMapper mapper = new ObjectMapper();

		ObjectReader reader = mapper.reader(values);
		JacksonInjectPOJO jacksonInjectPOJO =  reader.readValue(jsonString, JacksonInjectPOJO.class);

		System.out.println(jacksonInjectPOJO.getId());
		System.out.println(jacksonInjectPOJO.getEmail());
		System.out.println(jacksonInjectPOJO.getFirst_name());
		System.out.println(jacksonInjectPOJO.getLast_name());
	
	}
}

//o/p
//115
//nanicharan@gmail.com
//Agni
//Charan