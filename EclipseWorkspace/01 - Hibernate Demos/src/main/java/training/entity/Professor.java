package training.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// @DiscriminatorValue("PROF")
public class Professor extends Human {
	private Double salary;

	public Professor() {
	}

	public Professor(Integer id, String name, String email, Double salary) {
		super(id, name, email);
		this.salary = salary;
	}

}
