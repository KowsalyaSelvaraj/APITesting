package com.workwith.jsonfile;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;



public class JSONReadingExample {

	@Test
	public void readJsonFile() throws IOException, ParseException {

		JSONParser parser = new JSONParser();

		FileReader reader = new FileReader("WriteJsonFile.json");

		Object parsedObject = parser.parse(reader);

		JSONObject jsonObject = (JSONObject) parsedObject;

		String userNameString = (String) jsonObject.get("Name");
		Long age = (Long) jsonObject.get("Age");

		System.out.println("Name "+userNameString);
		System.out.println("Age "+age);
		JSONArray array =	(JSONArray) jsonObject.get("Special Qualities");

		Iterator iterator = array.iterator();

		while(iterator.hasNext()) {
			System.out.println("Special Qualities=>"+iterator.next());
		}
	}
}
