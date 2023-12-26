package com.restassured.jsonschema;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class HamcrestMatcherJsonSchemaValidator {

	@Test
	public void validate() throws IOException {
		
		File inputJson = new File("src/test/resources/input.json");	
		String jsonContentString = FileUtils.readFileToString(inputJson,"UTF-8");
		File jsonSchemaFile = new File("src/test/resources/schema.json");
		MatcherAssert.assertThat(jsonContentString, JsonSchemaValidator.matchesJsonSchema(jsonSchemaFile));
		
	}
}
