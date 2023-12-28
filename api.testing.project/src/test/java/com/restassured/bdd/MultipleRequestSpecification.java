package com.restassured.bdd;

import java.io.File;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;


public class MultipleRequestSpecification {

	RequestSpecification requestSpec;

	@BeforeSuite
	public void specifyRequest() {
		requestSpec =	RestAssured.given()
				.baseUri("http://localhost:3000")
				.basePath("/employees");
		RestAssured.requestSpecification = requestSpec;
	}	

	@Test
	public void getAllEmployee() {

		RestAssured
		.given()
		.when()
		.get()
		.prettyPrint();
	}

	@Test
	public void getAnEmployee() {

		RestAssured
		.given()
		.when()
		.get("/10")
		.prettyPrint();
	}
	
	@Test
	public void createAnEmployee() {
		File jsonFile = new File("src/test/resources/input.json");
		RequestSpecification specification = RestAssured.given()
				.baseUri("http://localhost:3000")
				.basePath("/employees")
				.header("Content-Type","application/json");
		
		RestAssured
		.given()
		.spec(specification)
		.body(jsonFile)
		.when()
		.post()
		.prettyPrint();
	}
	
	@Test
	public void createAnotherEmployee() {
		File jsonFile = new File("src/test/resources/input.json");

		RestAssured
		.given()
		.body(jsonFile)
		.header("Content-Type","application/json")
		.when()
		.post()
		.prettyPrint();
	}
}
