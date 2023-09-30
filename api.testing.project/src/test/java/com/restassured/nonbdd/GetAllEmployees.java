package com.restassured.nonbdd;

import java.security.cert.CertStoreSpi;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetAllEmployees {

	@Test(enabled = true,priority = 1)
	public void getAllEmployees() {

		RestAssured.baseURI = "http://localhost:3000/";

		RequestSpecification requestSpecification = RestAssured.given();

		Response response = requestSpecification.request(Method.GET,"employees/");

		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());

	}

	@Test(enabled = true,priority = 2)
	public void createAnEmployee() {
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification requestSpecification =	RestAssured.given().header("Content-Type","application/json")
				.body("{\r\n"
						+ "      \"first_name\": \"John\",\r\n"
						+ "      \"last_name\": \"Mount\",\r\n"
						+ "      \"email\": \"john@gmail.com\"\r\n"
						+ "    }");
		Response response =	requestSpecification.request(Method.POST,"employees/");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
	}


	@Test(priority = 3)
	public void updateAnEmployee() {
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification requestSpecification = RestAssured.given().header("Content-Type","application/json")
				.body("{\r\n"
						+ "    \"first_name\": \"Agni\",\r\n"
						+ "    \"last_name\": \"Prasath\",\r\n"
						+ "    \"email\": \"agniprasath@gmail.com\"\r\n"
						+ "  }");

		Response response = requestSpecification.request(Method.PUT,"employees/2/");
		System.out.println(response.asPrettyString());
		System.out.println(response.contentType());
		System.out.println(response.getStatusLine());

	}

	@Test(priority = 4)
	public void deleteAnEmployee() {
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification requestSpecification = RestAssured.given();

		//employee 5 is deleted
		Response response = requestSpecification.request(Method.DELETE,"employees/5");

		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}

	@Test(priority = 5)
	public void getAnEmployee() {
		RestAssured.baseURI = "http://localhost:3000/";
		RequestSpecification requestSpecification = RestAssured.given();
		Response response = requestSpecification.request(Method.GET,"employees/1");
		System.out.println(response.asPrettyString());
		System.out.println(response.getStatusLine());
	}
}
