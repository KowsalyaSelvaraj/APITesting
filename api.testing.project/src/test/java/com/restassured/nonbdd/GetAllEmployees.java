package com.restassured.nonbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployees {

	@Test
	public void getAllEmployees() {

		RestAssured.baseURI = "http://localhost:3000/";

		RequestSpecification requestSpecification = RestAssured.given();

		Response response = requestSpecification.request(Method.GET,"employees");
		
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	
	}
}
