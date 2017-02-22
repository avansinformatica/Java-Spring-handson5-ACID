package sample.web.ui.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public abstract class BaseOrder {
	
	@Id
	@GeneratedValue
	private Long id;
	
	public abstract int price();
}
