
package guru.springframework.api.domain;

import java.io.Serializable;

import guru.springframework.api.domain.common.DomainCommon;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login extends DomainCommon implements Serializable {

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
    private final static long serialVersionUID = 1041720428871730372L;
	
    private String username;
    private String password;
    private String md5;
    private String sha1;
    private String sha256;

}
