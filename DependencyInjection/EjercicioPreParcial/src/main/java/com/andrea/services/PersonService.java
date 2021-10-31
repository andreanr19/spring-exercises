package com.andrea.services;

import com.andrea.model.Person;
import com.andrea.repositories.IPersonRepository;

public class PersonService implements IPersonService{

	private IPersonRepository ipr;
	
	public  PersonService(IPersonRepository ipr) {
		this.ipr=ipr;
	}
	
	
	@Override
	public void agregarPersona(Person p) {
		ipr.agregarPersona(p);
	}

	@Override
	public void removePersona(Person p) {
		ipr.removePersona(p);
	}

}
