package com.deserialization.interview.questions;

import java.util.Arrays;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RelationBTWGettersSettersAndSerializeDeserialize {


	EmployeeGS employee;
	String serializedString;
	String responseBodyString;
	ObjectMapper mapper = new ObjectMapper();

	@Test(priority = 1)
	public void serializeData() throws JsonProcessingException {

		employee = new EmployeeGS();

		employee.setFirstNameString("Vikram");
		employee.setLastNameString("Vedha");
		employee.setEmailIdString("vikramh@gmail.com");
		employee.setSkillStrings(Arrays.asList("Police","Chasing"));

		serializedString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employee);
		System.out.println(serializedString);
	}

	@Test
	public void deserializeData() throws JsonMappingException, JsonProcessingException {

		String employeeJsonString = "{\r\n"
				+ "  \"firstNameString\" : \"Vikram\",\r\n"
				+ "  \"lastNameString\" : \"Vedha\",\r\n"
				+ "  \"emailIdString\" : \"vikramh@gmail.com\",\r\n"
				+ "  \"skillStrings\" : [ \"Police\", \"Chasing\" ]\r\n"
				+ "}";

		EmployeeGS employeeGS =	mapper.readValue(employeeJsonString, EmployeeGS.class);

		System.out.println("Printing Directly From POJO");
		System.out.println("First Name "+employeeGS.getFirstNameString());
		System.out.println("Last Name "+employeeGS.getLastNameString());
		System.out.println("Email Id "+employeeGS.getEmailIdString());
		System.out.println("Skills "+employeeGS.getSkillStrings());
	}
}
