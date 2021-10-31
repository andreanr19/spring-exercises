package com.andrea;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.andrea.model.Person;
import com.andrea.services.PersonService;

@SpringBootApplication
public class EjercicioPreParcialApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioPreParcialApplication.class, args);
	}

	@Bean
	public CommandLineRunner dummy(PersonService pr) {
		return (args) -> {
			
			Person p1 = new Person("Andrea", "Nuñez");
			Person p2 = new Person("AndreS", "Nuñez");
			
			pr.agregarPersona(p1);
			pr.agregarPersona(p2);
			
			pr.removePersona(p2);
		};
		
	}
}
