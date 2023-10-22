package com.restassured.bdd;

import static org.testng.Assert.assertFalse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateUpateAndReadData {

	@Test(enabled = false)
	public void getUserDetails() {
		
		RestAssured
			.given()
				.baseUri("https://gorest.co.in")
			.when()
				.get("/public/v2/users")
			.prettyPrint();
	}
	
	@Test(enabled = true)
	public void createUserWithDetails() {
		RestAssured
			.given()
				.baseUri("http://localhost:3000/")
				.header("Content-Type","application/json")
				.body(" {\r\n"
						+ "    \"first_name\": \"Rajini\",\r\n"
						+ "    \"last_name\": \"SuperStar\",\r\n"
						+ "    \"email\": \"rajini@gmail.com\"\r\n"
						+ "  }")
			.when()
				.post("employees/")
			.prettyPrint();
	}
	
	@Test(enabled = false)
	public void getEmployeeDetails() {
		
		RestAssured
			.given()
				.baseUri("http://localhost:3000/")
			.when()
				.get("employees/8")
			.prettyPrint();
		
	}
	
	@Test(enabled = false)
	public void updateEmployeeDetails() {
		RestAssured
		.given()
			.baseUri("http://localhost:3000/")
			.header("Content-Type","application/json")
			.body(" {\r\n"
					+ "    \"first_name\": \"Robot\",\r\n"
					+ "    \"last_name\": \"SuperStar\",\r\n"
					+ "    \"email\": \"rajini@gmail.com\"\r\n"
					+"\r\n"
					+ "  }")
		.when()
			.put("employees/8/")
		.prettyPrint();
	}
	
	@Test(enabled = false)
	public void deleteAnEmployee() {
		RestAssured
			.given()
				.baseUri("http://localhost:3000/")
			.when()
				.delete("employees/8/")
			.prettyPrint();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
