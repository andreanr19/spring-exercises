package com.andrea.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier("persona2")
public class PersonaRepoImpl2 implements IPersonaRepo{

	private static Logger LOG = LoggerFactory.getLogger(BeanPostProcessor.class);

	@Override
	public void registrar(String nombre) {

		LOG.info("NO se registro a " + nombre);
	}

}
