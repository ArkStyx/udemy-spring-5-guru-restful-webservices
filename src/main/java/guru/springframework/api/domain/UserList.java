package guru.springframework.api.domain;

import java.io.Serializable;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserList  implements Serializable {
	
	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
    private final static long serialVersionUID = -978265773832044746L;
	
	List<User> userList;
}
