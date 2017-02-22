package sample.web.ui.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class DecoratedOrder extends BaseOrder {
	
	@OneToOne
	protected BaseOrder order;
	
	protected DecoratedOrder(BaseOrder order) {
		this.order = order;
	}

}
