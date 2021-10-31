package com.AnnotationDI.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Professor {

	@Value(value="Nilang")
	private String name;
	
	//Constructor
	public Professor() {
		System.out.println("Object of Professor is created");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name=name;
	}
}
