package com.camilo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.camilo.model.Person;
import com.camilo.services.PersonService;
@ComponentScan(basePackages = "com.camilo")
@SpringBootApplication
public class RepasoEjercicio1Application {


	public static void main(String[] args) {

		

		ApplicationContext c = SpringApplication.run(RepasoEjercicio1Application.class,args);
		PersonService ps= c.getBean(PersonService.class);
		Person p1= new Person("CamiloEscobar");
		ps.createPerson(p1);


	}

}