package com.prediction.service;



import java.io.IOException;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("EmailService")
public class EmailServiceImpl implements EmailService{

	@Autowired
	   public JavaMailSender emailSender;
		
		public void sendmail()throws AddressException, MessagingException, IOException {
			   Properties props = new Properties();
			   props.put("mail.smtp.auth", "true");
			   props.put("mail.smtp.starttls.enable", "true");
			   props.put("mail.smtp.host", "smtp.gmail.com");
			   props.put("mail.smtp.port", "587");
			   
			   Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			      protected PasswordAuthentication getPasswordAuthentication() {
			         return new PasswordAuthentication("abc@gmail.com", "password");
			      }
			   });
			   Message msg = new MimeMessage(session);
			   msg.setFrom(new InternetAddress("abc@gmail.com", false));

			   msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("abc@gmail.com"));
			   msg.setSubject("Email regarding Job Apply status");
			   msg.setContent("Dear Candidate, <br><br>  <b>You are Shortlisted for the applied job. </b> <br><br> Regards, <br>Admin", "text/html");
			   msg.setSentDate(new Date());
	//
//			   MimeBodyPart messageBodyPart = new MimeBodyPart();
//			   messageBodyPart.setContent("email", "text/html");
	//
//			   Multipart multipart = new MimeMultipart();
//			   multipart.addBodyPart(messageBodyPart);
//			   MimeBodyPart attachPart = new MimeBodyPart();
	//
//			   attachPart.attachFile("/var/tmp/image19.png");
//			   multipart.addBodyPart(attachPart);
//			   msg.setContent(multipart);
			   Transport.send(msg);   
			}
}
