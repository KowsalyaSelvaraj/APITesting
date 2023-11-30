package com.restassured.bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CRUDOperationsBDD {

	@Test
	public void getAllEmployees() {
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
		.when()
			.get("/employees")
		.prettyPrint();
			
	}
	
	@Test
	public void createEmployee() {
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.header("Content-Type","application/json")
			.body("{\r\n"
					+ "    \"first_name\": \"Tony\",\r\n"
					+ "    \"last_name\": \"Stack\",\r\n"
					+ "    \"email\": \"tonyman@gmail.com\"\r\n"
					+"\r\n"
					+ "  }")
		.when()
			.post("/employees")
		.prettyPrint();
	}
	
	@Test
	public void updateEmployee() {
		
		RestAssured
			.given()
				.baseUri("http://localhost:3000")
				.header("Content-Type","application/json")
				.body("{\r\n"
					+ "    \"first_name\": \"Toony\",\r\n"
					+ "    \"last_name\": \"Stack\",\r\n"
					+ "    \"email\": \"tonystack@gmail.com\"\r\n"
					+"\r\n"
					+ "  }")
			.when()
				.put("/employees/12")
			.prettyPrint();
	}
	
	@Test
	public void deleteEmployee() {
		
		RestAssured
			.given()
				.baseUri("http://localhost:3000")
			.when()
				.delete("/employees/13")
			.prettyPrint();
	}
}
