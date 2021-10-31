package com.AutowireXML_ByType.beans;

public class HRService {

	private EmailService emailService=null;
	
	//Setter DI method
	public void setEmailService(EmailService emailService) {
		this.emailService=emailService;
	}
	
	public void initiateSeparation() {
		if(emailService !=null) {
			emailService.sendEmail();
		}
	}
}
