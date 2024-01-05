package com.deserialization.interview.questions;

import io.restassured.RestAssured;

public class NoURLPreditOutput {

	
	public static void main(String[] args) {
		RestAssured
		.given()
		.log()
		.all()
		.when()
		.get();
	}
}

//Output
//Request method:	GET
//Request URI:	http://localhost:8080/
//Proxy:			<none>
//Request params:	<none>
//Query params:	<none>
//Form params:	<none>
//Path params:	<none>
//Headers:		Accept=*/*
//Cookies:		<none>
//Multiparts:		<none>
//Body:			<none>
//Exception in thread "main" java.net.ConnectException: Connection refused: connect