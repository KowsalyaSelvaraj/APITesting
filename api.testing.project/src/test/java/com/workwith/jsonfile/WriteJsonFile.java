package com.workwith.jsonfile;

import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class WriteJsonFile {

	
	@Test
	public void writeJsonFile() throws IOException {
		//JSON Object
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Name", "Vijay");
		jsonObject.put("Age", 30);
		
		//JSON Array
		
		JSONArray array = new JSONArray();
		array.put("Magical Smile");
		array.put("Magnetic eyes");
		
		jsonObject.put("Special Qualities", array);
		
		FileWriter writer = new FileWriter("WriteJsonFile.json");
		
		writer.write(jsonObject.toString());
		
		writer.close();
	}
}
