package com.restassured.authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class BearerTokenExample {

	@Test
	public void bearerToken() {

		String tokenString = "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";

		RestAssured
		.given()
		.header("Authorization","Bearer "+tokenString)
		.when()
		.get("https://api.github.com/user/repos")
		.prettyPrint();
	}
}

//Output
//"id": 545408607,
//"node_id": "R_kgDOIIJGXw",
//"name": "APITesting",
//"full_name": "KowsalyaSelvaraj/APITesting",
//"private": false,
//"owner": {
//    "login": "KowsalyaSelvaraj",
//}