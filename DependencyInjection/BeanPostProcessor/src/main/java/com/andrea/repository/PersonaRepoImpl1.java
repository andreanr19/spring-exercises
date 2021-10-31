package com.andrea.repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;


@Repository
@Qualifier("persona1")
public class PersonaRepoImpl1 implements IPersonaRepo {

	private static Logger LOG = LoggerFactory.getLogger(BeanPostProcessor.class);

	@Override
	public void registrar(String nombre) {

		LOG.info("Se registro a " + nombre);
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Called postConstruct method");
	}

	@PreDestroy()
	public void clearCache() {
		System.out.println("Called clearCache method");
	}
}
