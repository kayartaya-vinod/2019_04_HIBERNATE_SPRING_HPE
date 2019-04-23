package training.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Laptop {
	@Id
	private String serialNumber;
	private String make;
	private String model;
	
	@ManyToOne
	@JoinColumn(name="emp_id", unique=true)
	private Employee owner;
}





