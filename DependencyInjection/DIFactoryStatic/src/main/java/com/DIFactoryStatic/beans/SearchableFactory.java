package com.DIFactoryStatic.beans;

public class SearchableFactory {
	
	private static SearchableFactory searchableFactory;
	
	//Static method to get instance of Searchable Factory
	public static SearchableFactory getSearchableFactory() {
		if(searchableFactory ==null) {
			searchableFactory = new SearchableFactory();
		}
		System.out.println("Factory method is used: getSearchableFactory ");
		return searchableFactory;
	}

}
