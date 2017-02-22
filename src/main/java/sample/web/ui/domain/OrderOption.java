package sample.web.ui.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class OrderOption extends DecoratedOrder {
	
	private String name;
	private int price;
	
	public OrderOption(String name, int price, BaseOrder order) {
		super(order);
		this.name = name;
		this.price = price;
	}
	
	@Override
	public int price() {
		return price + order.price();
	}
	
	@Override
	public String toString() {
		return "option: " + name + "; " + order;
	}

}
