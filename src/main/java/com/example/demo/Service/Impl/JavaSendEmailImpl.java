package com.example.demo.Service.Impl;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.demo.Service.JavaSendEmail;
@Service
public class JavaSendEmailImpl implements JavaSendEmail{
 
	@Autowired
	private JavaMailSender emailSender;
	
	@Override
	public void sendEmail(String toEmail, String subject, String body) {
	try {
		MimeMessage message = emailSender.createMimeMessage();
		MimeMessageHelper help = new MimeMessageHelper(message);
		help.setFrom("datd15287@gmail.com");
		help.setTo(toEmail);
		help.setSubject(subject);
		help.setText(body);
		
		emailSender.send(message);
		
		System.out.println("send email success");
	}catch(Exception ex) {
		throw new RuntimeException(ex);
	}
		
	}

}
