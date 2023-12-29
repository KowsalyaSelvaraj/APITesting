package com.restassured.bdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderExample {



	@Test

	public void getAnEmployee() {

		RequestSpecBuilder builder = new RequestSpecBuilder();

		builder.setBaseUri("http://localhost:3000");
		builder.setBasePath("/employees/10");

		RequestSpecification requestSpecification = builder.build();

		RestAssured.given(requestSpecification).get().prettyPrint();
	}

	@Test
	public void getAnotherEmployee() {

		RequestSpecBuilder builder = new RequestSpecBuilder();

		//builder pattern
		RequestSpecification requestSpecification = builder.setBaseUri("http://localhost:3000").setBasePath("/employees").build();

		RestAssured.given(requestSpecification).when().get("/{number}", "12").prettyPrint();
		
	}
}
