package com.shopx.mail;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {
	String to;
	String subject;
	String text;
	
	public Email(String to, String subject, String text) {
		this.to = to;
		this.subject = subject;
		this.text = text;
	}
	
	public void Sendmail() {
		try {
			System.out.println("============Mail============");
			final String username = "comlogix69@gmail.com";
			final String password = "Nfx69@$$";
			
			Properties props = new Properties();
			props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
	
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			message.setText(text);

			Transport.send(message);
			
			System.out.println("Mail sended successfully");
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
}
