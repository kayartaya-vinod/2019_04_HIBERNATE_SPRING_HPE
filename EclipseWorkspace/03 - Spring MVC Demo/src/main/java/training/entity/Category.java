package training.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="categories")
public class Category {
	
	@Id
	@GeneratedValue(generator="increment")
	@Column(name="category_id")
	private Integer categoryId;
	@Column(name="category_name")
	private String categoryName;
	private String description;
	private byte[] picture;
	
	@OneToMany(cascade= { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="category_id")
	private List<Product> products = new ArrayList<Product>();
	
	// helper function to do bidirectional association
	public void addProduct(Product p) {
		this.products.add(p);
		p.setCategory(this);
	}

}






