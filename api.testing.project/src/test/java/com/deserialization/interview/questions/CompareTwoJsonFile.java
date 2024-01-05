package com.deserialization.interview.questions;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompareTwoJsonFile {

	public static void main(String[] args) throws JsonMappingException, JsonProcessingException {
		// TODO Auto-generated method stub

		String json1 = "{\r\n"
				+ "    \"first_name\": \"Superman\",\r\n"
				+ "    \"last_name\": \"Hulck\",\r\n"
				+ "    \"email\": \"superman@gmail.com\"\r\n"
				+ "  }";

		String json2 = "{\r\n"
				+ "    \"first_name\": \"Superman\",\r\n"
				+ "    \"last_name\": \"Hulck\",\r\n"
				+ "    \"email\": \"superman@gmail.com\"\r\n"
				+ "  }";

		ObjectMapper mapper = new ObjectMapper();

		JsonNode node1 = mapper.readTree(json1);

		JsonNode node2 = mapper.readTree(json2);
		
		System.out.println("Compare 2 json file result : "+node1.equals(node2));
	}

}
