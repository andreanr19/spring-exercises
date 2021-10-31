package com.DIFactoryStatic;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.DIFactoryStatic.beans.SearchableFactory;

public class App {
  public static void main(String[] args) {

	  ApplicationContext springContext = new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans.xml");
	  
	  SearchableFactory sf = (SearchableFactory)springContext.getBean("searchableFactory");
  }
}
