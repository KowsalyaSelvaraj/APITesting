package com.lombok.pojo;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Movies {

	
	private String title;
	private int year;
	private List<String> cast;
		
}
