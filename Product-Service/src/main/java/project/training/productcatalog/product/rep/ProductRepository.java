package project.training.productcatalog.product.rep;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import project.training.productcatalog.product.dto.ProductResponse;
import project.training.productcatalog.product.model.Product;
import project.training.productcatalog.product.model.Sub_Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	@Query("from Product where pname = ?1 and category = ?2")
	List<Product> findByPnameCategory(String pname, String category);
	
	@Modifying
	@Transactional
	@Query("delete from Product where pname = ?1 and category =?2")
	void removeProductItem(String pname, String category);
	
	@Query("from Product where pname = ?1 and category = ?2")
	Product findByCategoryPname(String pname, String category);
		
	@Query("from Product where pname like ?1%")
	List<Product> findByPname(String pname);
	
	@Query("from Product where status = ?1 order by pname")
	List<Product> findProduct(String status);
	
	@Modifying
	@Transactional
	@Query("update Product set status = ?1, msg=?2 where pname = ?3 and category = ?4")
	void updateProduct(String status,String msg, String pname, String category);
	
	@Query("from Product where category='wireline' and status='approve'")
	List<Product> getAllWirelineProduct();
	
	@Query("from Product where category='wireless' and status='approve'")
	List<Product> getAllWirelessProducts();
}
