package com.diConstructor.constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.diConstructor.beans.EmployeeService;

public class DIWithConstructorCheck {
  public static void main(String[] args) {
	  
	  ApplicationContext springContext = new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans.xml");
	  
	  EmployeeService employeeService = (EmployeeService) springContext.getBean("employeeService");
	  employeeService.showEmployeeName();
  
  }
}
