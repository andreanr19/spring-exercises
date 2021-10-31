package com.camilo.services;

import com.camilo.model.Person;

public interface IPersonService {
	public void createPerson(Person p);

	public void removePerson(int hashCode);
}