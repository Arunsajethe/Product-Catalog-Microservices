package project.training.productcatalog.product.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import project.training.productcatalog.product.dto.ProductResponse;
import project.training.productcatalog.product.model.Product;
import project.training.productcatalog.product.service.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/productSpring")
public class ProductController {
	
	private final ProductService productService;
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/product")
	public Product createProduct(@RequestBody Product product)
	{
		System.out.println("Product Inserting working");
		System.out.println(product);
		
		if(product.getEmail().equals("superadmin"))
		{
			product.setStatus("approve");
			product.setMsg("Super Admin has approved your Product");
		}
		else
		{
			product.setStatus("pending");
		}
		productService.insertProduct(product);
		return product;
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/product")
	public List<Product> ProductNameChecking( @RequestParam String pname, @RequestParam String category)
	{	
		System.out.println("Checking Product Name");
		System.out.println(pname+" "+category);
		System.out.println(productService.checkProductNameExisting(pname, category));
		return productService.checkProductNameExisting(pname, category);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/vendorProduct")
	public List<ProductResponse> vendorProduct()
	{
		return productService.vendorProductDisplay();
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/product/display")
	public List<ProductResponse> getAllProducts()
	{
		return productService.display();
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/product")
	public Product removeProduct(@RequestParam String pname, @RequestParam String category) throws InterruptedException
	{
		System.out.println(pname+" "+category);
		productService.deleteProduct(pname, category);
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/product/{pname}/{category}")
	public ProductResponse getByNameCategory(@PathVariable ("pname") String pname, @PathVariable ("category") String category)
	{
		System.out.println(pname+" "+category);
		System.out.println(productService.getByCategoryAndName(pname, category));
		return productService.getByCategoryAndName(pname, category);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/product")
	public ProductResponse updateProduct(@RequestBody ProductResponse product )
	{
		System.out.println(product);
		return productService.updatingProduct(product);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/search/{pname}")
	public List<ProductResponse> searchProduct(@PathVariable ("pname") String pname)
	{
		System.out.println(pname);
		System.out.println(productService.searchByCategory(pname));
		return productService.searchByCategory(pname);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/approveProduct")
	public ProductResponse approveProduct(@RequestParam String pname, @RequestParam String category, @RequestParam String status, @RequestParam String msg)
	{
		System.out.println(pname+"  "+category+"  "+status );
		productService.statusUpdating(status, pname, category, msg);
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/getWireline")
	public List<ProductResponse> getAllWireline()
	{
		return productService.displayAllWireline();
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/getWireless")
	public List<ProductResponse> getAllWireless()
	{
		return productService.displayAllWireless();
	}
}
