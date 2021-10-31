package com.andrea;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.andrea.service.IPersonaService;

@SpringBootApplication
public class BeanPostProcessorApplication implements CommandLineRunner{

	private static Logger LOG = LoggerFactory.getLogger(BeanPostProcessor.class);
	@Autowired
	private ConfigurableApplicationContext context;
	
	@Autowired
	private IPersonaService service;
	public static void main(String[] args) {
		SpringApplication.run(BeanPostProcessorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		service.registrar("ANDREA");

		context.close();
	}
	
	
}
