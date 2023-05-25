package guru.springframework.api.domain;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserData {

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
    private final static long serialVersionUID = 4382483581291975398L;
	
	private List<User> data;
	
}
