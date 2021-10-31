package com.camilo.model;



import lombok.extern.log4j.Log4j2;

@Log4j2
public class Person {
	private String name;

	public Person(String name) {
		super();
		this.name = name;
		
		log.info("Se creó persona");
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
}
