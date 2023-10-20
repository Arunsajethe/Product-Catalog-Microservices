package project.training.productcatalog.subproduct.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import project.training.productcatalog.subproduct.dto.Sub_ProductRequest;
import project.training.productcatalog.subproduct.dto.Sub_ProductResponse;
import project.training.productcatalog.subproduct.entity.Sub_Product;
import project.training.productcatalog.subproduct.service.Sub_ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/subproductSpring")
public class Sub_ProductController {
	
	private final Sub_ProductService service;
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/subProducts")
	public List<Sub_ProductResponse> displayAll()
	{
		return service.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/subProducts")
	public Sub_Product insertingData(@RequestBody Sub_ProductRequest productRequest)
	{
		System.out.println(productRequest);
		return service.addSubproduct(productRequest);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/subProducts/{sname}")
	public List<Sub_ProductResponse> checkingSubProduct(@PathVariable String sname)
	{
		System.out.println(sname);
		System.out.println(service.checking(sname));
		return service.checking(sname);
	}

}
