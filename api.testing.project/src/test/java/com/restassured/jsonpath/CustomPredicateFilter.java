package com.restassured.jsonpath;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Predicate;

public class CustomPredicateFilter {

	File jsonFile = new File("src/test/resources/bookstore.json");
	
	@Test
	public void customPredicate() throws IOException {
		
		Predicate booksWithISBNPredicate = new Predicate() {
			
			@Override
			public boolean apply(PredicateContext ctx) {
				
				boolean predicate = ctx.item(Map.class).containsKey("isbn");
				return predicate;
			}
		};
		
		
		Predicate predicate = ctx->ctx.item(Map.class).containsKey("isbn");
		
		List<Map<String, Object>> resultList =  JsonPath.parse(jsonFile).read("$..book[?].isbn",booksWithISBNPredicate);
		List<Map<String, Object>> resultList1 =  JsonPath.parse(jsonFile).read("$..book[?].isbn",predicate);
	
		System.out.println(resultList);
		System.out.println(resultList1);
	}
}
