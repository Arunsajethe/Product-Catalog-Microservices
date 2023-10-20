package project.training.productcatalog.emailsending.service;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {
	
	private final JavaMailSender javaMailSender;
	
	//constructor of service
	public EmailService(JavaMailSender javaMailSender)
	{
		this.javaMailSender = javaMailSender;
	}
	
	//service method to send email
	public void SendEmail(String toEmail, String subject, String body)
	{
		try 
		{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom("gdrive05hari@gmail.com");
            helper.setTo(toEmail);
            helper.setSubject(subject);
            helper.setText(body, true); 

            javaMailSender.send(message);
        } 
		catch (MessagingException e) 
		{
            e.printStackTrace();
        }
	}
	
	
}
