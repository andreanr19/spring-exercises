package com.DISetter.beans;

public class DocumentBase {

	private DocFinder docFinder;
	
	//Setter method to inject dependency
	public void setDocFinder(DocFinder docFinder) {
		this.docFinder = docFinder;
	}
	
	public void performSearch() {
		this.docFinder.doFind();
	}
}
