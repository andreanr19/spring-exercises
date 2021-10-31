package com.AutowireXML_ByName.beans;

public class AccountService {

	private UserService userService=null;
	
	//Setter DI method
	public void setUserService(UserService userService) {
		this.userService=userService;
	}
	
	public  void processUserAccount() {
		if(userService !=null) {
			userService.getUserDetail();
		}
			
	}
}
