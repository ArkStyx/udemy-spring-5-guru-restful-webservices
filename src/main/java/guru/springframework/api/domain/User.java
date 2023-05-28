package guru.springframework.api.domain;

import java.io.Serializable;

import guru.springframework.api.domain.common.DomainCommon;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User extends DomainCommon implements Serializable {
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
    private final static long serialVersionUID = -3532048267747973846L;
	
    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company company;
}
