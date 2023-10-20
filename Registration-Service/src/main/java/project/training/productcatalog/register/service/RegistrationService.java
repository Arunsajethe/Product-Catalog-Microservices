package project.training.productcatalog.register.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.training.productcatalog.register.jpa.RegistrationRepository;
import project.training.productcatalog.register.model.Registration;

@Service
public class RegistrationService {
	
	@Autowired
	private RegistrationRepository repo;
	
	public Registration insert(Registration registration)
	{
		repo.save(registration);
		return registration;
	}
	
	public List<Registration> checkByEmail(String email)
	{
		return repo.findByEmail(email);
	}
	
	public List<Registration> getAll()
	{
		return repo.findAll();
	}
	
	public Registration updateStatus(String checkStatus, String email)
	{
		 repo.updateCheckStatus(checkStatus, email);
		 return null;
	}

	public Registration removeRegistration(String email)
	{
		repo.deleteRegistration(email);
		return null;
	}
	
	public void updatePassword(String email, String password)
	{
		System.out.println(email);
		System.out.println(password);
		repo.forgetPassword(password, email);
		System.out.println("password changed");
	}
	
	public Registration checkingEmailAndPassword(String email, String password)
	{
		System.out.println(repo.getByEmailAndPassword(email, password));
		return repo.getByEmailAndPassword(email, password);
	}
	
}
