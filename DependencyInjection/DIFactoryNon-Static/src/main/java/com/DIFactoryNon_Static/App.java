package com.DIFactoryNon_Static;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.DIFactoryNon_Static.beans.SalaryService;

public class App {
  public static void main(String[] args) {

	  ApplicationContext springContext = new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans.xml");
	  SalaryService ss = (SalaryService) springContext.getBean("salaryService");
	  ss.showEmployeeType();
  }
}
