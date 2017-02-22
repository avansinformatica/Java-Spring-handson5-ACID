package sample.web.ui.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Order extends BaseOrder {

	@OneToMany(cascade = javax.persistence.CascadeType.ALL)
	private List<Product> orderItems = new ArrayList<>();
	
	public void add(Product p) {
		orderItems.add(p);
	}
	
	@Override
	public int price() {
		int price = 0;
		for(Product item : orderItems) {
			price += item.getPrice();
		}
		return price;
	}
	
	@Override
	public String toString() {
		String s = "";
		for(Product item : orderItems) {
			s += "product: " + item.getName() + "; ";
		}
		return s;
	}

}
