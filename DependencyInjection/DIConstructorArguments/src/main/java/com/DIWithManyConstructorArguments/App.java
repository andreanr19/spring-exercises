package com.DIWithManyConstructorArguments;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.DIConstructor.beans.Camera;

public class App {
  public static void main(String[] args) {
	  
	  ApplicationContext springContext = new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans.xml");
	  
	  Camera myCamera= (Camera)springContext.getBean("camera");
	  
	  myCamera.showSettings();
  }
}
