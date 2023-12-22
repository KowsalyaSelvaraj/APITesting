package com.workwith.jsonfile;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import io.restassured.RestAssured;

public class EmployeePOJO_1 {

	@Test
	public void objectMapperSteps() throws JsonProcessingException {

		EmployeePOJO employeePOJO = new EmployeePOJO();
		employeePOJO.setFirst_name("Raj");
		employeePOJO.setLast_name("Mohan");
		employeePOJO.setEmail("rajmohan@gmail.com");

		employeePOJO.setSkills(Arrays.asList("Direction","Acting"));

		System.out.println(employeePOJO.getFirst_name());
		System.out.println(employeePOJO.getLast_name());
		System.out.println(employeePOJO.getEmail());
		System.out.println(employeePOJO.getSkills());

		//object mapper from jackson

		ObjectMapper mapper = new ObjectMapper();

		ObjectWriter writer =	mapper.writerWithDefaultPrettyPrinter();
		String jsonString = writer.writeValueAsString(employeePOJO);
		
		System.out.println(jsonString);
		
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.header("Content-Type","application/json")
			.body(jsonString)
		.when()
			.post("/employees")
		.then()
			.log()
			.all();
	}



}
