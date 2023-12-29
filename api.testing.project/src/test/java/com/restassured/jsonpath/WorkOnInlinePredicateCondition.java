package com.restassured.jsonpath;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.testng.annotations.Test;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

public class WorkOnInlinePredicateCondition {

	
	//fetch price of books that cost less than 10
	//Book 3,1
	@Test
	public void predicateExample() throws IOException {
		
		File jsonFile = new File("src/test/resources/bookstore.json");
		
		DocumentContext context = JsonPath.parse(jsonFile);
		
		List<Object> booksPriceLessThanTenList =  context.read("$..book[?(@.price<10)].price");
		
		System.out.println(booksPriceLessThanTenList);
		
		
	}
	
	//fetch books with price lesser than 10 and category equal to reference
	//book 1 
	@Test
	public void predicateWithANDCondition() throws IOException {
		
		File jsonFile = new File("src/test/resources/bookstore.json");
		
		
		List<Object> booksWithPriceAndCategory = JsonPath.parse(jsonFile)
				.read("$..book[?(@.price<10 && @.category=='reference')]");
		
		System.out.println(booksWithPriceAndCategory);		
		
	}
	
	
	//fetch books with price greater than 10 or category equal to reference
	//Book 1,2,4
	@Test
	public void predicateWithORCondition() throws IOException {
		
		File jsonFile = new File("src/test/resources/bookstore.json");
		
		List<Object> booksWithPriceOrCategory = JsonPath.parse(jsonFile)
				.read("$..book[?(@.price>10 || @.category=='reference')]");
		
		System.out.println(booksWithPriceOrCategory);
	}
	
	
	//fetch books which is neither price greater than 10 nor category equal to reference
	//Book 3
	@Test
	public void predicateWithNOTCondition() throws IOException {
		
		File jsonFile = new File("src/test/resources/bookstore.json");
		
		List<Object> booksWithnotPriceAndCategory = JsonPath.parse(jsonFile)
		.read("$..book[?(!(@.price>10 || @.category=='reference'))]");
		
		System.out.println(booksWithnotPriceAndCategory);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
