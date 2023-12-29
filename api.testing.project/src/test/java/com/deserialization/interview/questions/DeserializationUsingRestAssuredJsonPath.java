package com.deserialization.interview.questions;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class DeserializationUsingRestAssuredJsonPath {

	@Test
	public void deserializeRAJsonPaht() {
		
		File jsonfile = new File("src/test/resources/inputRestAssured.json");
		JsonPath jsonPath = JsonPath.from(jsonfile);
		
		EmployeeInput inputDataEmployeeInput =  jsonPath.getObject("$", EmployeeInput.class);
		
		System.out.println("First Name "+inputDataEmployeeInput.getFirstNameString());
		System.out.println("Last Name "+inputDataEmployeeInput.getLastNameString());
		System.out.println("Email Id "+inputDataEmployeeInput.getEmailIdString());
		System.out.println("Skills "+inputDataEmployeeInput.getSkillStrings());
	}
}
