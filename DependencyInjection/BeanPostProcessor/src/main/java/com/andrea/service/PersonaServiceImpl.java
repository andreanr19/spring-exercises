package com.andrea.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.andrea.repository.IPersonaRepo;

@Service
public class PersonaServiceImpl implements IPersonaService {

	@Autowired
	@Qualifier("persona2")
	private IPersonaRepo repo;
	@Override
	public void registrar(String nombre) {
		
		repo.registrar(nombre);
	}

}
