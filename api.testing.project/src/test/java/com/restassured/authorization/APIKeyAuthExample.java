package com.restassured.authorization;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class APIKeyAuthExample {


	@Test
	public void apiKeyAuth() {

		RestAssured
		.given()
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather?q=Madurai&appid=96c7c09b813d27cfffbc2ed9cc056af7")
		.then()
		.log()
		.body();
	}
	
	
	@Test
	public void apiKeyAuthUsingQueryParam() {

		RestAssured
		.given()
			.queryParam("q", "Madurai")
			.queryParam("appid", "96c7c09b813d27cfffbc2ed9cc056af7")
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather")
		.then()
		.log()
		.body();
	}
	
	@Test
	public void apiKeyAuthUsingQueryParam1() {

		RestAssured
		.given()
			.queryParam("q", "Madurai")
			.queryParam("appid", "96c7c09b813d27cfffbc2ed9cc056af7")
			.baseUri("https://api.openweathermap.org")
		.when()
		.get("/data/2.5/weather")
		.then()
		.log()
		.body();
	}
	

	@Test
	public void apiKeyAuthUsingHeader() {

		RestAssured
		.given()
			.header("appid", "96c7c09b813d27cfffbc2ed9cc056af7")
		.when()
		.get("https://api.openweathermap.org/data/2.5/weather?q=Madurai")
		.then()
		.log()
		.body();
	}
	
	
}
