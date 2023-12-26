package com.deserialization.interview.questions;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class DeserializationUsingObjectMapper {

	EmployeeInput employee;
	String serializedString;
	String responseBodyString;

	@Test(priority = 1)
	public void addDataForEmployee() {

		employee = new EmployeeInput();

		employee.setFirstNameString("Dhanush");
		employee.setLastNameString("D");
		employee.setEmailIdString("dhanush@gmail.com");
		employee.setSkillStrings(Arrays.asList("Fight","Dance"));

		System.out.println("Printing Directly From POJO");
		System.out.println("First Name "+employee.getFirstNameString());
		System.out.println("Last Name "+employee.getLastNameString());
		System.out.println("Email Id "+employee.getEmailIdString());
		System.out.println("Skills "+employee.getSkillStrings());
	}

	@Test(priority = 2)
	public void serializePOJO() throws JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();

		serializedString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println("*********************************");
		System.out.println("Printing Serialized Object Data");
		System.out.println(serializedString);
	}

	@Test(priority = 3)
	public void postSerializedDataToEMS() {

		System.out.println("*********************************");
		System.out.println("Printing Response After posting serialized Data");
		responseBodyString = RestAssured
				.given()
				.baseUri("http://localhost:3000")
				.header("Content-Type","application/json")
				.body(serializedString)
				.when()
				.post("/employees")
				.prettyPrint();

		//System.out.println(responseBodyString);
	}

	@Test(priority = 4)
	public void deserialiseResponseString() throws JsonMappingException, JsonProcessingException {

		ObjectMapper mapper = new ObjectMapper();
		EmployeeOutput employeeObjectAfterDeserialization = mapper.readValue(responseBodyString, EmployeeOutput.class);
		System.out.println("*********************************");
		System.out.println("Printing After Deserialization");
		System.out.println("First Name "+employeeObjectAfterDeserialization.getFirstNameString());
		System.out.println("Last Name "+employeeObjectAfterDeserialization.getLastNameString());
		System.out.println("Email Id "+employeeObjectAfterDeserialization.getEmailIdString());
		System.out.println("Skills "+employeeObjectAfterDeserialization.getSkillStrings());
		System.out.println("Id "+employeeObjectAfterDeserialization.getId());

	}
	
	//Output
	//	Printing Directly From POJO
	//	First Name Dhanush
	//	Last Name D
	//	Email Id dhanush@gmail.com
	//	Skills [Fight, Dance]
	//	*********************************
	//	Printing Serialized Object Data
	//	{
	//	  "firstNameString" : "Dhanush",
	//	  "lastNameString" : "D",
	//	  "emailIdString" : "dhanush@gmail.com",
	//	  "skillStrings" : [ "Fight", "Dance" ]
	//	}
	//	*********************************
	//	Printing Response After posting serialized Data
	//	{
	//	    "firstNameString": "Dhanush",
	//	    "lastNameString": "D",
	//	    "emailIdString": "dhanush@gmail.com",
	//	    "skillStrings": [
	//	        "Fight",
	//	        "Dance"
	//	    ],
	//	    "id": 31
	//	}
	//	*********************************
	//	Printing After Deserialization
	//	First Name Dhanush
	//	Last Name D
	//	Email Id dhanush@gmail.com
	//	Skills [Fight, Dance]
	//	Id 31
	//	PASSED: com.deserialization.interview.questions.DeserializationUsingObjectMapper.addDataForEmployee
	//	PASSED: com.deserialization.interview.questions.DeserializationUsingObjectMapper.deserialiseResponseString
	//	PASSED: com.deserialization.interview.questions.DeserializationUsingObjectMapper.serializePOJO
	//	PASSED: com.deserialization.interview.questions.DeserializationUsingObjectMapper.postSerializedDataToEMS
	//
	//	===============================================
	//	    Default test
	//	    Tests run: 4, Failures: 0, Skips: 0
	//	===============================================
	//
	//
	//	===============================================
	//	Default suite
	//	Total tests run: 4, Passes: 4, Failures: 0, Skips: 0
	//	===============================================


}
