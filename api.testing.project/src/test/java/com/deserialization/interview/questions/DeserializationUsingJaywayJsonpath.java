package com.deserialization.interview.questions;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.spi.mapper.JacksonMappingProvider;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class DeserializationUsingJaywayJsonpath {

	EmployeeInput employeeInput;
	String 	serializedDataString;
	String responseString;

	@Test(priority = 1)
	public void setDataForEmployeeInputClass() {


		employeeInput = new EmployeeInput();

		employeeInput.setFirstNameString("Velu");
		employeeInput.setLastNameString("Police");
		employeeInput.setEmailIdString("velu@gmail.com");
		employeeInput.setSkillStrings(Arrays.asList("Running","Kabadi"));

		System.out.println("Printing Directly From POJO");
		System.out.println("First Name "+employeeInput.getFirstNameString());
		System.out.println("Last Name "+employeeInput.getLastNameString());
		System.out.println("Email Id "+employeeInput.getEmailIdString());
		System.out.println("Skills "+employeeInput.getSkillStrings());
	}

	@Test(priority = 2)
	public void serializeEmployeeInput() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();

		serializedDataString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employeeInput);
		System.out.println("*********************************");
		System.out.println("Printing Serialized Object Data");
		System.out.println(serializedDataString);


	}

	@Test(priority = 3)
	public void postData() {

		Response response =	RestAssured.given()
				.baseUri("http://localhost:3000")
				.body(serializedDataString)
				.header("Content-Type","application/json")
				.when()
				.post("/employees");

		responseString = response.asPrettyString();
		System.out.println(responseString);
	}

	@Test(priority = 4)
	public void deserialiseUsingJaywayJson() {

		JacksonMappingProvider mappingProvider = new JacksonMappingProvider();

		Configuration configuration = Configuration
				.builder()
				.mappingProvider(mappingProvider)
				.build();
		EmployeeOutput	employeeOutput  = JsonPath
				.using(configuration)
				.parse(responseString)
				.read("$",EmployeeOutput.class);
		
		System.out.println("*********************************");
		System.out.println("Printing After Deserialization");
		System.out.println("First Name "+employeeOutput.getFirstNameString());
		System.out.println("Last Name "+employeeOutput.getLastNameString());
		System.out.println("Email Id "+employeeOutput.getEmailIdString());
		System.out.println("Skills "+employeeOutput.getSkillStrings());
		System.out.println("Id "+employeeOutput.getId());
	}
} 
