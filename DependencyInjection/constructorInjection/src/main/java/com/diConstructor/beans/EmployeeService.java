package com.diConstructor.beans;


public class EmployeeService {
	
	private Logger log;
	
	//Constructor
	public EmployeeService(Logger log) {
		this.log=log;
	}
	
	//Service method.
	public void showEmployeeName() {
		log.info("ShowEmployeeName method is called...");
		log.debug("This is debbuging point");
		log.error("Some exception occured here");
	}

}
