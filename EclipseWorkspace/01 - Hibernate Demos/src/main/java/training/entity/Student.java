package training.entity;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
//@DiscriminatorValue("STUD")
public class Student extends Human {
	private String subject;
	private Double gpa;
	
	public Student() {
	}

	public Student(Integer id, String name, String email, String subject, Double gpa) {
		super(id, name, email);
		this.subject = subject;
		this.gpa = gpa;
	}
	
	
}
