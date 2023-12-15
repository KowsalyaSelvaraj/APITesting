package com.restassured.jsonschema;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion.VersionFlag;
import com.networknt.schema.ValidationMessage;

public class NetworkNtJsonSchemaValidator {


	@Test
	public void jsonSchemaValidatorNetworkNt() throws IOException {

		ObjectMapper mapper = new ObjectMapper();

		JsonSchemaFactory factory = JsonSchemaFactory.getInstance(VersionFlag.V4);

		File inputJson = new File("src/test/resources/input.json");
		InputStream inputSchema = new FileInputStream("src/test/resources/schema.json");

		JsonNode jsonNode = mapper.readTree(inputJson);

		JsonSchema schema =	factory.getSchema(inputSchema);

		Set<ValidationMessage> result =	schema.validate(jsonNode);

//in schema add 2 fields in required then those 2 fields will be shown here
		//like below 
		//$.job: is missing but it is required
		//$.codework: is missing but it is required
	
		if(result.isEmpty()) {
			System.out.println("Every thing is fine in input json");
		}else {
			for(ValidationMessage message : result) {
				System.out.println(message);
			}

		}
	}
}
