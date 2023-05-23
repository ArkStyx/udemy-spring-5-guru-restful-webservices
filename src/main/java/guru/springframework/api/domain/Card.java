
package guru.springframework.api.domain;

import java.io.Serializable;

import guru.springframework.api.domain.common.DomainCommon;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Card extends DomainCommon implements Serializable {

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
    private final static long serialVersionUID = 6203456183354582742L;
	
    private String type;
    private String number;
    private ExpirationDate expirationDate;
    private String iban;
    private String swift;

}
