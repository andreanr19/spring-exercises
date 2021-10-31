package com.andrea;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.andrea.model.Person;
import com.andrea.services.PersonService;

@SpringBootApplication
public class EjercicioPreParcialApplication {

	public static void main(String[] args) {
		ApplicationContext c= SpringApplication.run(EjercicioPreParcialApplication.class, args);
		
		PersonService ps= c.getBean(PersonService.class);
		
		PersonService ps2 = c.getBean(PersonService.class);
		Person p1 = new Person("Andrea", "Nuñez");
		ps.agregarPersona(p1);
		ps2.removePersona(p1);
		
		System.out.println(ps);
		System.out.println(ps2);
	}

		
	
}
