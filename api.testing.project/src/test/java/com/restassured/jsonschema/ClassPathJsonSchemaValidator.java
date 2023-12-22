package com.restassured.jsonschema;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
//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
//kowsi.23kowsalya@gmail.com
public class ClassPathJsonSchemaValidator {

	@Test
	public void jsonSchemaValidationInClassPath() {
		
		File inputjsonFile = new File("src/test/resources/input.json");
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.header("Content-Type","application/json")
			.body(inputjsonFile)
		.when()
			.post("/employees")
		.then()
			.body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema.json"));
	}
	
	@Test
	public void jsonSchemaValidationUsingFile() {
		
		File inputJsonFile = new File("src/test/resources/input.json");
		
		File schemaFile = new File("src/test/resources/schema.json");
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.body(inputJsonFile)
			.header("Content-Type","application/json")
		.when()
			.post("/employees")
		.then()
			.body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
	}
	
	@Test
	public void jsonSchemaValidationUsingInputStream() throws FileNotFoundException {
		
		File inputJsonFile = new File("src/test/resources/input.json");
		
		InputStream schemaFile = new FileInputStream("src/test/resources/schema.json");
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.body(inputJsonFile)
			.header("Content-Type","application/json")
		.when()
			.post("/employees")
		.then()
			.body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
	}
	
	@Test
	public void jsonSchemaValidationUsingFileReader() throws FileNotFoundException {
		
		File inputJsonFile = new File("src/test/resources/input.json");
		
		Reader schemaFile = new FileReader("src/test/resources/schema.json");
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.body(inputJsonFile)
			.header("Content-Type","application/json")
		.when()
			.post("/employees")
		.then()
			.body(JsonSchemaValidator.matchesJsonSchema(schemaFile));
	}
	
	@Test(enabled = false)
	public void jsonSchemaValidationUsingString() throws FileNotFoundException {
		
		File inputJsonFile = new File("src/test/resources/input.json");
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.body(inputJsonFile)
			.header("Content-Type","application/json")
		.when()
			.post("/employees")
		.then()
			.body(JsonSchemaValidator.matchesJsonSchema("give complete json schema content here"));
	}
}
