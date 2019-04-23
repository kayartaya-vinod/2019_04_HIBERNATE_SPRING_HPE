package training.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="customers")
@Getter
@Setter
public class Customer {
	@Id
	@Column(name="customer_id")
	private String customerId;
	@Column(name="company_name")
	private String companyName;
	@Column(name="contact_name")
	private String contactName;
	@Column(name="contact_title")
	private String contactTitle;
	@Embedded
	private ContactDetails contactDetails;
	private String phone;
	private String fax;
	
	// list of all employees who have processed 'this' customer's orders
	@ManyToMany
	@JoinTable(name="orders",
			joinColumns = @JoinColumn(name="customer_id"),
			inverseJoinColumns= @JoinColumn(name="employee_id"))
	private Set<Employee> employees;
}












