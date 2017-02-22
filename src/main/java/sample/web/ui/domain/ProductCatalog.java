package sample.web.ui.domain;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ProductCatalog {

	@Id
	@GeneratedValue
	private Long id;
	
	@OneToMany(cascade = javax.persistence.CascadeType.ALL)
	private Map<Long, StockItem> products = new HashMap<>();
	
	// add new product to catalog and indicate number of stock items
	// precondition: product must have an id!
	public void add(Product product, int quantity) {
		assert(product.getId() != null);
		
		products.put(product.getId(), new StockItem(product, quantity));
	}
	
	// precondition: product in catalog
	// precondition: at least one product in stock
	public Product decrementStock(Long productId) {
		assert(products.containsKey(productId));
		assert(products.get(productId).getQuantity() >= 0);
		
		StockItem si = products.get(productId);
		products.put(productId, si.decrementStock());
		return si.getProduct();
	}
}
