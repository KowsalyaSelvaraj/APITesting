package com.restassured.bdd;

import java.io.File;

import org.junit.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class RequestSpecificationExample {

	RequestSpecification requestSpecification;

	@BeforeSuite
	public void specifyRequest() {
		requestSpecification =	RestAssured.given()
				.baseUri("http://localhost:3000")
				.basePath("/employees");
	}


	@Test
	public void getAllEmployee() {

		RestAssured
		.given()
		.spec(requestSpecification)
		.baseUri("http://localhost:3000")
		.when()
		.get()
		.prettyPrint();
	}

	@Test
	public void getAnEmployee() {

		RestAssured
		.given()
		.spec(requestSpecification)
		.when()
		.get("/10")
		.prettyPrint();
	}

	@Test
	public void createAnEmployee() {
		File jsonFile = new File("src/test/resources/input.json");

		RestAssured
		.given()
		.spec(requestSpecification)
		.body(jsonFile)
		.header("Content-Type","application/json")
		.when()
		.post()
		.prettyPrint();
	}
	
	@Test
	public void createAnotherEmployee() {
		File jsonFile = new File("src/test/resources/input.json");

		RestAssured
		.given()
		.spec(requestSpecification)
		.body(jsonFile)
		.header("Content-Type","application/json")
		.when()
		.post()
		.prettyPrint();
	}
}
