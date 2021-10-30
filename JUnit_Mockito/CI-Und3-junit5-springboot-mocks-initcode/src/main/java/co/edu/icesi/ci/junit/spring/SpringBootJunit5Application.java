package co.edu.icesi.ci.junit.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.icesi.ci.junit.spring"})
public class SpringBootJunit5Application {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJunit5Application.class, args);
	}
}
