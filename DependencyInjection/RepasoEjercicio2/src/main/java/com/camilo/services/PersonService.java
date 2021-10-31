package com.camilo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.camilo.model.Person;
import com.camilo.repositories.IPersonRepository;
import com.camilo.repositories.PersonRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
@Scope("prototype")
public class PersonService implements IPersonService {

	public IPersonRepository pr;


	@Autowired
	public PersonService(IPersonRepository pr) {

		this.pr = pr;
		log.info("Se creó el servicio Persona y holi");
	}

	public void createPerson(Person p) {
		pr.createPerson(p);
	}

	public void removePerson(int hashCode) {

		pr.removePerson(hashCode);

	}
}
