package com.restassured.nonbdd;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CRUDOperationNonBDD {

	@Test
	public void getAllEmployees() {

		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification requestSpecification = RestAssured.given();

		Response response = requestSpecification.request(Method.GET,"/employees");

		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}

	@Test
	public void createEmployee() {
		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification requestSpecification = RestAssured.given().header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"first_name\": \"Superman\",\r\n"
						+ "    \"last_name\": \"Hulck\",\r\n"
						+ "    \"email\": \"superman@gmail.com\"\r\n"
						+ "  }");

		Response response =	requestSpecification.request(Method.POST,"/employees");

		System.out.println(response.asPrettyString());
	}

	@Test
	public void updateEmployee() {
		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification requestSpecification = RestAssured.given().header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"first_name\": \"Superman\",\r\n"
						+ "    \"last_name\": \"Hulck1\",\r\n"
						+ "    \"email\": \"superman123@gmail.com\"\r\n"
						+ "  }");

		Response response =	requestSpecification.request(Method.PUT,"/employees/10");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}

	@Test
	public void deleteEmployee() {

		RestAssured.baseURI = "http://localhost:3000";

		RequestSpecification requestSpecification = RestAssured.given();

		Response response =	requestSpecification.request(Method.DELETE,"/employees/11");

		System.out.println(response.asPrettyString());
		System.out.println(response.statusLine());
	}





}
