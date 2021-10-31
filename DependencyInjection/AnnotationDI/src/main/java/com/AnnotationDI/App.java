package com.AnnotationDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.AnnotationDI.beans.Subject;

public class App {
  public static void main(String[] args) {
	  
	  ApplicationContext springContext = new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans.xml");
	  Subject mySubject = (Subject) springContext.getBean("subject");
	  mySubject.taughtBy();
	  
  }
}
