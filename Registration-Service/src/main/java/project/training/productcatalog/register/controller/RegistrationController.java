package project.training.productcatalog.register.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import project.training.productcatalog.register.model.Registration;
import project.training.productcatalog.register.service.RegistrationService;

@RestController
@RequestMapping("/registerSpring")
public class RegistrationController {
	
	@Autowired
	private RegistrationService service;
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/register")
	public Registration create(@RequestBody Registration reg)
	{
		System.out.println(reg);
		reg.setCheckstatus("Disapprove");
		reg.setRole("ROLE_VENDOR");
		service.insert(reg);
		return reg;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/register/{email}")
	public List<Registration> findEmail(@PathVariable ("email") String email)
	{
		System.out.println(email);
		System.out.println(service.checkByEmail(email));
		return service.checkByEmail(email);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/register")
	public List<Registration> display()
	{
		System.out.println("Get Mapping working");
		System.out.println(service.getAll());
		return service.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/register")
	public Registration updateCheckStatus(@RequestParam String email, @RequestParam String checkStatus)
	{
		
		System.out.println(email+" "+checkStatus);
		service.updateStatus(checkStatus, email);
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/register/{email}")
	public Registration deleteRegistration(@PathVariable String email)
	{
		System.out.println(email);
		service.removeRegistration(email);
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/changepassword")
	public Registration changPassword(@RequestParam String email, @RequestParam String password)
	{
		System.out.println(email+" "+password);
		service.updatePassword(email, password);
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("loginChecking/{email}/{password}")
	public Registration loginChecking(@PathVariable ("email") String email, @PathVariable ("password") String password)
	{
		System.out.println(email+" "+password);
		return service.checkingEmailAndPassword(email, password);
	}
	
	
	
}
