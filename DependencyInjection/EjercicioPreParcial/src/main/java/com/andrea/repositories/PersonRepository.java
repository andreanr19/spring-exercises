package com.andrea.repositories;

import java.util.ArrayList;
import java.util.List;

import com.andrea.model.Person;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class PersonRepository implements IPersonRepository {

	private List<Person> personas;
	
	public PersonRepository() {
		personas = new ArrayList<Person>();
	}
	
	public void  agregarPersona(Person p) {
		
		personas.add(p);
		log.info("Se agregó " + p.getFirstName());
	}
	
	public void removePersona(Person p) {
		personas.remove(p);
		log.info("Se eliminó " +p.getFirstName());
	}
}
