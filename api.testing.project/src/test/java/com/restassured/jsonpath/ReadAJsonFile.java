package com.restassured.jsonpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.swing.text.Document;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.InvalidJsonException;
import com.jayway.jsonpath.JsonPath;

public class ReadAJsonFile {


	@Test
	public void readEveryTime() throws IOException {

		File jsonFile = new File("src/test/resources/bookstore.json");

		List<Object> priceList = JsonPath.read(jsonFile, "$..price");

		for(Object price : priceList) {
			System.out.println(price);
		}
	}

	@Test
	public void readOnlyOneTime() throws InvalidJsonException, IOException {

		InputStream jsonFile = new FileInputStream("src/test/resources/bookstore.json");

		Object jsonDocumentObject =	Configuration.defaultConfiguration().jsonProvider().parse(jsonFile.readAllBytes());

		List<Object> categoryList = JsonPath.read(jsonDocumentObject, "$..category");

		for(Object category : categoryList) {
			System.out.println(category);
		}

		jsonFile.close();

	}

	@Test
	public void fluentAPI() throws IOException {
		File jsonFile = new File("src/test/resources/bookstore.json");

		DocumentContext context = JsonPath.parse(jsonFile);

		List<Object> priceList = context.read("$..price");

		for(Object price : priceList) {
			System.out.println(price);
		}

		Configuration configuration = Configuration.defaultConfiguration();

		Integer bookArrayLength = 	JsonPath
				.using(configuration)
				.parse(jsonFile)
				.read("$.store.book.length()");
		
		System.out.println("Book array length : "+bookArrayLength);
	}

	@Test
	public void DefiniteAndIndefinitePath() throws IOException {
		//indefinite path
		File jsonFile = new File("src/test/resources/bookstore.json");

		List<Object> priceList = JsonPath.read(jsonFile, "$..price");

		for(Object price : priceList) {
			System.out.println(price);
		}

		//definite path

		String authorNameString = 	JsonPath.read(jsonFile, "$.store.book[0].author");

		System.out.println("Author Name : "+authorNameString);
	}
}
