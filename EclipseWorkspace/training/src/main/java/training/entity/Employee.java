package training.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Getter
@Setter
public class Employee {
	@Id
	@GeneratedValue(generator = "increment")
	@Column(name = "employee_id")
	private Integer employeeId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String title;
	@Column(name = "title_of_courtesy")
	private String titleOfCourtesy;
	@Column(name = "birth_date")
	private Date birthDate;
	@Column(name = "hire_date")
	private Date hireDate;
	@Embedded
	private ContactDetails contactDetails;
	@Column(name = "home_phone")
	private String homePhone;
	private String extension;
	private byte[] photo;
	private String notes;

	// @Column(name="reports_to", insertable=false, updatable=false)
	// private Integer reportsTo;
	
	@ManyToOne
	@JoinColumn(name = "reports_to")
	private Employee manager;

	@OneToMany(mappedBy = "manager")
	// @JoinColumn(name="reports_to")
	private List<Employee> subordinates;
	
	@OneToOne(mappedBy="owner") // "owner" is the member in "Laptop" with FK info
	private Laptop laptop;

}







