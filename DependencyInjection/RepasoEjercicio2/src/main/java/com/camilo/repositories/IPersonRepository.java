package com.camilo.repositories;

import com.camilo.model.Person;

public interface IPersonRepository {
	public void createPerson(Person p);

	public void removePerson(int hashcode);
}
