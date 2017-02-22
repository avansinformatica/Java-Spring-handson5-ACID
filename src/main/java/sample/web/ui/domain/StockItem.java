package sample.web.ui.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class StockItem {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@OneToOne(cascade = javax.persistence.CascadeType.ALL)
	private Product product;
	private int quantity;

	public StockItem(Product p, int q) {
		this.product = p;
		this.quantity = q;
	}

	public StockItem decrementStock() {
		quantity--;
		return this;
	}
}
