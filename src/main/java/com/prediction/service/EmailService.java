package com.prediction.service;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

public interface EmailService {
	
	void sendmail() throws AddressException, MessagingException, IOException;


}
