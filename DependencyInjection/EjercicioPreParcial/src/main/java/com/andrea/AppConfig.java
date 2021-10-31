package com.andrea;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.andrea.repositories.IPersonRepository;
import com.andrea.repositories.PersonRepository;
import com.andrea.services.IPersonService;
import com.andrea.services.PersonService;

@Configuration
public class AppConfig {
	
	@Bean
	public IPersonRepository getIPersonRepository() {
		return new PersonRepository();
	}
	
	@Bean
	public IPersonService getIPersonService() {
		return new PersonService(getIPersonRepository());
	}

}
