package com.DIFactoryNon_Static.beans;

//Factory Bean who has Factory method.
public class EmployeeService {
	// Instance Factory method

	public Employee getEmployee(String type) {
		Employee employee = null;
		if ("developer".equalsIgnoreCase(type)) {

			employee = new Developer("developer");
		} else if ("manager".equalsIgnoreCase(type)) {

			employee = new Manager("manager");
		}

		return employee;
	}
}
