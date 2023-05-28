package guru.springframework.api.domain;

import java.io.Serializable;

import guru.springframework.api.domain.common.DomainCommon;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address extends DomainCommon implements Serializable {

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
    private final static long serialVersionUID = 5677338081290507077L;
	
	private String street;
	private String suite;
	private String city;
	private String zipcode;
	private Geo geo;
}
