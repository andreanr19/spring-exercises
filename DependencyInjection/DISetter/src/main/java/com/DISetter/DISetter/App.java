package com.DISetter.DISetter;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.DISetter.beans.DocumentBase;

public class App {
  public static void main(String[] args) {
	  
	  ApplicationContext springContext = new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans.xml");
	  
	  DocumentBase db = (DocumentBase) springContext.getBean("docBase");
	  db.performSearch();
  
  }
}
