package AnnationDIFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import AnnotationDIFactory.beans.SalaryService;

public class App {
  public static void main(String[] args) {

	  ApplicationContext springContext =new ClassPathXmlApplicationContext("com/pruebasXml/xml/beans.xml");
	  SalaryService ss = (SalaryService) springContext.getBean("salaryService");
  
  }
}
