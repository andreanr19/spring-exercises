package com.AutowireXML_ByName;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.AutowireXML_ByName.beans.*;

public class App {
  public static void main(String[] args) {
	  
	  ApplicationContext springContext = new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans_ByName.xml");
	  
	  AccountService as =(AccountService) springContext.getBean("accountService");
	  
	  as.processUserAccount();
  
  }
}
