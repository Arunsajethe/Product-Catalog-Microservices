package project.training.productcatalog.subproduct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SubProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SubProductServiceApplication.class, args);
	}

}
