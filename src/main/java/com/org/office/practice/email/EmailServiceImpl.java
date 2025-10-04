package com.org.office.practice.email;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;


@Service
public  class EmailServiceImpl implements EmailService {
	@Autowired private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") private String sender;
	
	public String sendSimpleMail(Email email) {
		 try {

	            // Creating a simple mail message
	            SimpleMailMessage mailMessage
	                = new SimpleMailMessage();

	            // Setting up necessary details
	            mailMessage.setFrom(sender);
	            mailMessage.setTo(email.getRecipient());
	            mailMessage.setText(email.getMsgBody());
	            mailMessage.setSubject(email.getSubject());

	            // Sending the mail
	            javaMailSender.send(mailMessage);
	            return "Mail Sent Successfully...";
	        }
		 catch (Exception e) {
			 System.out.println("error : " + e.getMessage());
	            return "Error while Sending Mail";
	        }
	}
	
	 public String
	    sendMailWithAttachment(Email email)
	    {
		 MimeMessage mimeMessage
         = javaMailSender.createMimeMessage();
     MimeMessageHelper mimeMessageHelper;

     try {

         // Setting multipart as true for attachments to
         // be send
         mimeMessageHelper
             = new MimeMessageHelper(mimeMessage, true);
         mimeMessageHelper.setFrom(sender);
         mimeMessageHelper.setTo(email.getRecipient());
         mimeMessageHelper.setText(email.getMsgBody());
         mimeMessageHelper.setSubject(
        		 email.getSubject());

         // Adding the attachment
         FileSystemResource file
             = new FileSystemResource ("C:\\Users\\shree\\Downloads\\users.xlsx");

         mimeMessageHelper.addAttachment(
             file.getFilename(), file);

         // Sending the mail
         javaMailSender.send(mimeMessage);
         return "Mail sent Successfully";
		 
	    }
     catch (MessagingException e) {

         // Display message when exception occurred
         return "Error while sending mail!!!";
     }
	    }

	
   }
