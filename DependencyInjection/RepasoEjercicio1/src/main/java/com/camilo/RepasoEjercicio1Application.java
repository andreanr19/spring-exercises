package com.camilo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.camilo.model.Person;
import com.camilo.services.PersonService;

@SpringBootApplication
public class RepasoEjercicio1Application {

	@Bean
	public CommandLineRunner dummy(PersonService pr) {
		return (args) -> {

			Person p1 = new Person("Andre");
			Person p2 = new Person("Camilo");

			pr.createPerson(p1);
			pr.createPerson(p2);

			pr.removePerson(p1.hashCode());
			pr.removePerson(p2.hashCode());

		};
	}

	public static void main(String[] args) {

		SpringApplication.run(RepasoEjercicio1Application.class, args);

//		ApplicationContext context = SpringApplication.run(RepasoEjercicio1Application.class, args);
//
//		PersonRepository pr = context.getBean(null);

	}

}