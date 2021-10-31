package JavaConfigurationDI.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Subject {

	private Professor professor;
	
	public Subject() {
		System.out.println("Object of Subject is created");
		
	}
	
	//Setter injection method
	@Autowired
	public void setProfessor(Professor professor) {
		System.out.println("setting the professor through setter method injection");
		this.professor=professor;
	}
	
	public void taughtBy() {
		if(professor !=null) {
			System.out.println("This subject is taught by " + professor.getName());
		}
	}
}