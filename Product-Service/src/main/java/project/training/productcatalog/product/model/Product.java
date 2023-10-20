package project.training.productcatalog.product.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="t_product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int pid;
	
	private String pname;
	
	private String recommended;
	
	private String category;
	
	private int validity;
	
	private List<String> features;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Sub_Product> subproducts;
	
	private String status;
	
	private String email;
	
	private String user;
	
	private String msg;

}
