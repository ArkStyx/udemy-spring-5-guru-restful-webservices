package guru.springframework.api.domain;

import java.io.Serializable;

import guru.springframework.api.domain.common.DomainCommon;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Company extends DomainCommon implements Serializable {

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
    private final static long serialVersionUID = 4661228813349752965L;
	
	private String name;
	private String catchPhrase;
	private String bs;
}
