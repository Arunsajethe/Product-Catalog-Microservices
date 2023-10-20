package project.training.productcatalog.emailsending.controller;

import java.io.UnsupportedEncodingException;
import java.util.Random;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import project.training.productcatalog.emailsending.model.Email;
import project.training.productcatalog.emailsending.model.Otp;
import project.training.productcatalog.emailsending.service.EmailService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/emailSpring")
public class EmailController {
	
	private final EmailService emailService;
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/sendOtp")
	public Otp sendingOtp(@RequestBody String toEmail)
	{	
		System.out.println(toEmail+" ");
		String sub = "One Time Password (OTP) for Reset Password";

		Email email = new Email();
		email.setToEmail(toEmail);
		email.setSubject(sub);
		
		Random random = new Random();
		int otp= 100000 + random.nextInt(900000); 
		email.setBody(myContent(otp));
		
		this.emailService.SendEmail(email.getToEmail(), email.getSubject(), email.getBody());
		
		Otp otp2 = new Otp();
		otp2.setOtp(otp);
		return otp2;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/approving")
	public ResponseEntity<Email> authoriztionFromSuperAdmin(@RequestParam String email, @RequestParam String oper) throws UnsupportedEncodingException, MessagingException
	{
		System.out.println(email+" "+oper);
		String sub = "Super Admin has "+oper+" your account";
		String body = operContent(oper);
		
		Email email2 = new Email();
		email2.setToEmail(email);
		email2.setSubject(sub);
		email2.setBody(body);
		
		this.emailService.SendEmail(email, sub, body);
		
		return ResponseEntity.ok(email2);
	}
	
	private String myContent(int otp)
	{
		String body = "<html><body>\"\r\n"
				+ "\r\n"
				+ "<p style='font-size: 18px;'>Dear Admin,</p>"
				+ "\r\n"
				+ "<p style='font-size: 16px;'>Your reset password password is "+otp+"</p>"
				+ "\r\n"
				+ "\r\n"
				+ "<p style='font-size: 16px;'>If you didn't want to reset password, you can ignore this email. Your password will not be changed.</p>"
				+ "\r\n"
				+ "</body></html>";
		return body;
	}
	
	private String operContent(String oper)
	{
		String body = "<html><body>\"\r\n"
				+ "\r\n"
				+ "<p style='font-size: 18px;'>Dear Admin,</p>"
				+ "\r\n"
				+ "<p style='font-size: 16px;'>We are sending you this email because "+ operationControl(oper)+"</p>"
				+ "\r\n"
				+ "</body></html>";
		return body;
	}
	
	private String operationControl(String oper)
	{
		if(oper.equals("Approve"))
		{
			return "Super Admin has approved your account.Now, you can log with email and password.";
		}
		else
		{
			return "Super Admin has suspended your account. Due to unathourized activity from you.";
		}
	}
	

}
