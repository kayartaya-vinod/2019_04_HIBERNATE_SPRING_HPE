package training.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	@Column(name="category_id")
	private Integer categoryId;
	@Column(name="category_name")
	private String categoryName;
	private String description;
	private byte[] picture;
	
	@OneToMany
	@JoinColumn(name="category_id")
	private List<Product> products;

}






