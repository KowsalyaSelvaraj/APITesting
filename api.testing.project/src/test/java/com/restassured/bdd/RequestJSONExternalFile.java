package com.restassured.bdd;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class RequestJSONExternalFile {

	@Test
	public void createEmployeeFromExternalJsonFile() {
		
		File jsonFile = new File("employee.json");
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.header("Content-Type","application/json")
			.body(jsonFile)
		.when()
			.post("/employees")
		.prettyPrint();
	}
}
