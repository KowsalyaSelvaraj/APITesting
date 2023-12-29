package com.restassured.authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BasicAuthExample {

	
	@Test
	public void basicAuth() {
		
		RestAssured
		.given()
			.auth()
			.basic("postman", "password")
			.baseUri("https://postman-echo.com")
		.when()
			.get("basic-auth")
		.prettyPrint();
	}
}

//output
//{
//    "authenticated": true
//}
