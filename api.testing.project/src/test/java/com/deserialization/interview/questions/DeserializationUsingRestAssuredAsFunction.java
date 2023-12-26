package com.deserialization.interview.questions;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;

public class DeserializationUsingRestAssuredAsFunction {


	@Test
	public void deserializePOJOUsingAsFunction() {

		EmployeeOutput employeeOutput =	RestAssured
				.given()
				.baseUri("http://localhost:3000")
				.when()
				.get("/employees/27")
				.then()
				.extract()
				.body()
				.as(EmployeeOutput.class);

		System.out.println("First Name "+employeeOutput.getFirstNameString());
		System.out.println("Last Name "+employeeOutput.getLastNameString());
		System.out.println("Email Id "+employeeOutput.getEmailIdString());
		System.out.println("Skills "+employeeOutput.getSkillStrings());
	}

	@Test
	public void deserializeUsingAsFunction() {

		Map<String, Object> responseAsMap =	RestAssured
				.given()
				.baseUri("http://localhost:3000")
				.when()
				.get("/employees/27")
				.then()
				.extract()
				.body()
				.as(new TypeRef<Map<String,Object>>() {
				});

		System.out.println("First Name "+responseAsMap.get("firstNameString"));
		System.out.println("Last Name "+responseAsMap.get("lastNameString"));
		System.out.println("Email Id "+responseAsMap.get("emailIdString"));
		System.out.println("Skills "+responseAsMap.get("skillStrings"));
		System.out.println("ID "+responseAsMap.get("id"));
	}
}
