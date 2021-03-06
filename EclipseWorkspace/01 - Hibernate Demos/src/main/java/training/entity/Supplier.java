package training.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "suppliers")
@Getter
@Setter
public class Supplier {
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "supplier_id")
	private Integer supplierId;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "contact_name")
	private String contactName;
	@Column(name = "contact_title")
	private String contactTitle;

	// represents address, city, region, postal_code and country
	@Embedded
	private ContactDetails contactDetails;
	
	private String phone;
	private String fax;
	@Column(name="home_page")
	private String homePage;
	
	@OneToMany(mappedBy="supplier") // "supplier" is the member in Product.java
	// containing the join-column information
	private List<Product> products;
	
}



