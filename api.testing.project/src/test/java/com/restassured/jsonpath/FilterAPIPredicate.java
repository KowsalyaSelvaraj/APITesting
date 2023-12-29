package com.restassured.jsonpath;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.jayway.jsonpath.Criteria;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.Filter;
import com.jayway.jsonpath.JsonPath;

public class FilterAPIPredicate {


	File jsonFile = new File("src/test/resources/bookstore.json");
	//filter for price less than 10
	//book 3,1
	@Test
	public void firstFilterCriteria() throws IOException {

		Filter firstFilter = Filter.filter(
				Criteria
				.where("price")
				.lt(10)		
				);

		List<Object> resultList = JsonPath.parse(new File("src/test/resources/bookstore.json"))
				.read("$..book[?].price",firstFilter);

		System.out.println(resultList);

	}

	//fetch books with price lesser than 10 and category equal to reference
	//book 1 

	@Test
	public void secondFilterCriteria() throws IOException {

		Filter secondFilter = Filter.filter(

				Criteria
				.where("price")
				.lt(10)
				.and("category")
				.is("reference")
				);

		DocumentContext context = JsonPath.parse(jsonFile);

		List<Map<String, Object>> resultList = context.read("$..book[?]",secondFilter);

		System.out.println("Result : "+resultList);
		System.out.println("1st author Name  "+resultList.get(0).get("author"));
	}

	//fetch books with price greater than 10 or category equal to reference
	//Book 1,2,4
	@Test
	public void thirdFilterCriteria() throws IOException {

		Filter thirdFilter = Filter.filter(
					Criteria
					.where("price")
					.lt(10)
					.and("category")
					.is("reference")
				);
		
		DocumentContext context = JsonPath.parse(jsonFile);

		List<Object> resultList = context.read("$..book[?]",thirdFilter);

		System.out.println("Result : "+resultList);
		
	}
}
