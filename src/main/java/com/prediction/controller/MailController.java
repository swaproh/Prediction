package com.prediction.controller;

import java.io.IOException;


import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prediction.service.EmailService;


@RestController
@RequestMapping(value="mail")
public class MailController {

	private static final Logger logger = LoggerFactory.getLogger(MailController.class);
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping(value = "/sendemail")
	public String sendEmail() throws AddressException, MessagingException, IOException {
		logger.info("Sendind notification to candidate");
	   emailService.sendmail();
	   return "Email sent successfully";   
	}
	
}
