package com.org.office.practice.email;

import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.activation.DataSource;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.util.ByteArrayDataSource;

@Service
public class EmailExcelExportService {
@Autowired private JavaMailSender javaMailSender;
	
	@Value("${spring.mail.username}") 
	private String sender;
	
	 public void sendMailWithExcelAttachment(String to, String subject, String body, ByteArrayInputStream attachmentStream, String attachmentFileName)throws MessagingException
	    {
		 MimeMessage mimeMessage = javaMailSender.createMimeMessage();




  
 MimeMessageHelper mimeMessageHelper  = new MimeMessageHelper(mimeMessage, true);

   mimeMessageHelper.setTo(to);
   mimeMessageHelper.setSubject(subject);
   mimeMessageHelper.setText(body);

   DataSource dataSource = new ByteArrayDataSource(attachmentStream.readAllBytes(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
   mimeMessageHelper.addAttachment(attachmentFileName, dataSource);


  
   javaMailSender.send(mimeMessage);
  
}


}
