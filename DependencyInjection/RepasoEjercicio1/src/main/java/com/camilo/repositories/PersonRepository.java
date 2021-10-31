package com.camilo.repositories;

import java.util.HashMap;
import java.util.Map;

import com.camilo.model.Person;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonRepository implements IPersonRepository{

	Map<Integer, Person> people;
	
	public PersonRepository() {
		log.info("Bean creado y holi");
		people = new HashMap<Integer, Person>();
	}

	public void createPerson(Person p) {
		log.info(p.toString());
		
		people.put(p.hashCode(), p);
		
	}
	
	public void removePerson(int hashcode) {
		people.remove(hashcode);
		
		log.info("Persona eliminada");
	}

}