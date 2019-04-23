package training.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@Entity
@Table(name = "order_details")
@Getter
@Setter
public class LineItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "order_id")
	private Integer orderId;
	@Id
	@Column(name = "product_id")
	private Integer productId;
	@Column(name = "unit_price")
	private Double unitPrice;
	private Double discount;
	private Integer quantity;

	public LineItem(Integer orderId, Integer productId) {
		this.orderId = orderId;
		this.productId = productId;
	}

}
