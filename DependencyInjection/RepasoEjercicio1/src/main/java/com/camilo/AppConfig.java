package com.camilo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.camilo.repositories.IPersonRepository;
import com.camilo.repositories.PersonRepository;
import com.camilo.services.IPersonService;
import com.camilo.services.PersonService;

@Configuration
public class AppConfig {

	@Bean
	public IPersonRepository getPersonRepository() {
		return new PersonRepository();
	}
	
	@Bean
	public IPersonService getPersonService() {
		return new PersonService(getPersonRepository());
	}

}
