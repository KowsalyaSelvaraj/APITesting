package com.deserialization.interview.questions;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.internal.SpecificationMerger;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;

public class RequestSpecificationPropertiesExample {

	@Test
	public void getDetails() {
		RestAssured.baseURI = "http://localhost:3000";
		RestAssured.basePath = "/employees";
		RequestSpecification requestSpecification = RestAssured.given().header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"first_name\": \"Superman\",\r\n"
						+ "    \"last_name\": \"Hulck\",\r\n"
						+ "    \"email\": \"superman@gmail.com\"\r\n"
						+ "  }");

	//	Response response =	requestSpecification.request(Method.POST);

		QueryableRequestSpecification queryableRequestSpecification 
		= SpecificationQuerier.query(requestSpecification);

		System.out.println(queryableRequestSpecification.getBasePath());
		System.out.println(queryableRequestSpecification.getBaseUri());
		System.out.println(queryableRequestSpecification.getHeaders());
		System.out.println(queryableRequestSpecification.getContentType());
	}
}


//output
///employees
//http://localhost:3000
//Content-Type=application/json
//application/json
