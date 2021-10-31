package JavaConfigurationDI;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import JavaConfigurationDI.beans.Professor;
import JavaConfigurationDI.beans.Subject;

public class App {
  public static void main(String[] args) {

	  ApplicationContext springContext = new AnnotationConfigApplicationContext(JavaBaseSpringConfig.class);
	  
	  Subject subject = (Subject) springContext.getBean("subjectBean");
	  
	  subject.taughtBy();
  
  }
}
