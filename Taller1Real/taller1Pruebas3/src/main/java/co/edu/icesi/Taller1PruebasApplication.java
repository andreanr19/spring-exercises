package co.edu.icesi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.icesi"})
public class Taller1PruebasApplication {

	public static void main(String[] args) {
		SpringApplication.run(Taller1PruebasApplication.class, args);
	}

}
