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
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@XmlRootElement(name="product-list")
@XmlAccessorType(XmlAccessType.FIELD)
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
	
	@XmlTransient
	@JsonIgnore
	private byte[] picture;
	
	@XmlTransient
	@JsonIgnore
	@OneToMany(cascade= { CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name="category_id")
	private List<Product> products = new ArrayList<Product>();
	
	// helper function to do bidirectional association
	public void addProduct(Product p) {
		this.products.add(p);
		p.setCategory(this);
	}

}






