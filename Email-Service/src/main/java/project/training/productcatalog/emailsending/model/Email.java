package project.training.productcatalog.emailsending.model;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Email {
	
	private String toEmail;
	
	private String subject;
	
	private String body;
	

}
