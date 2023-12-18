package com.workwith.jsonfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class SerializationProcess {

	
	@Test
	public void serializeDataToJsonFormat() {
		
		Map<String, Object> jsonBodyMap = new HashMap<String, Object>();
		
		jsonBodyMap.put("first_name", "Kowsalya");
		jsonBodyMap.put("last_name","Selvaraj");
		
		List<String> skillStrings = new ArrayList<String>();
		
		skillStrings.add("Java");
		skillStrings.add("Selenium");
		
		jsonBodyMap.put("skills", skillStrings);
		
		System.out.println(jsonBodyMap);
		
		
		RestAssured
		.given()
			.baseUri("http://localhost:3000")
			.header("Content-Type","application/json")
			.body(jsonBodyMap)
			.log()
			.all()
		.when()
			.post("/employees")
		.then()
			.log()
			.all();
	}
}
