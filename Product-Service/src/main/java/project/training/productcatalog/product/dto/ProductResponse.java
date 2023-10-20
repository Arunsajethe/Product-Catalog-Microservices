package project.training.productcatalog.product.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import project.training.productcatalog.product.model.Sub_Product;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductResponse {
	
	private String pname;
	
	private String recommended;
	
	private String category;
	
	private int validity;
	
	private List<String> features;
	
	private List<Sub_Product> subproducts;
	
	private String email;
	
	private String user;
	
	private String status;
	
	private String msg;

}
