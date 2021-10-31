package com.andrea.services;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.andrea.model.Person;
import com.andrea.repositories.IPersonRepository;

@Service
@Scope("prototype")
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

	public void setIpr(IPersonRepository ipr) {
		this.ipr= ipr;
	}
}
