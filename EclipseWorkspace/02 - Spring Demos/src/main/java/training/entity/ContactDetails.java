package training.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Embeddable
public class ContactDetails {
	private String address;
	private String city;
	private String region;
	@Column(name="postal_code")
	private String postalCode;
	private String country;
}
