package com.AutowireConstructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.AutowireConstructor.beans.ExamService;

public class App {
  public static void main(String[] args) {

	  ApplicationContext springContext = new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans.xml");
	  ExamService es= (ExamService) springContext.getBean("examService");
	  es.getExamDetails();
  }
}
