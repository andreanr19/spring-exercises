package com.AutowireXML_ByTypes;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.AutowireXML_ByType.beans.HRService;

public class App {

	public static void main(String[] args) {

		ApplicationContext springContext = new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans_ByType.xml");
		HRService hrs= (HRService) springContext.getBean("hrService");
		hrs.initiateSeparation();
	}

}
