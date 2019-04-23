package training.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
// Approach #1
// @Inheritance(strategy = InheritanceType.SINGLE_TABLE)
// @DiscriminatorColumn(name = "HUMAN_TYPE", discriminatorType =
// DiscriminatorType.STRING)

// Approach #2
// @Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)

// Approach #3 (normalized)
@Inheritance(strategy=InheritanceType.JOINED)
public class Human {
	@Id
	private Integer id;
	private String name;
	private String email;

	public Human() {
	}

	public Human(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

}
