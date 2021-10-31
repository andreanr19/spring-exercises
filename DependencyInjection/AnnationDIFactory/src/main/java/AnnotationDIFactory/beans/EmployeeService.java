package AnnotationDIFactory.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EmployeeService {

	//INSTANCE FACTORY METHOD WITH ANNOTATION
	@Bean()
	public Employee getEmployee(@Value("developer") String type) {
		Employee employee= null;
		if("developer".equalsIgnoreCase(type)) {
			employee = new Developer("developer");
		}else if("manager".equals(type)) {
			employee= new Manager("manager");
		}
		System.out.println("Employee of type " + type+ " is created");
		return employee;
	}
}
