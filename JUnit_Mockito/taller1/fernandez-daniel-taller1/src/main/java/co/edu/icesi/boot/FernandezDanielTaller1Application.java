package co.edu.icesi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"co.edu.icesi"})
@EnableAutoConfiguration(exclude= {DataSourceAutoConfiguration.class})
public class FernandezDanielTaller1Application {

	public static void main(String[] args) {
		SpringApplication.run(FernandezDanielTaller1Application.class, args);
	}

}