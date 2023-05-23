package guru.springframework.api.domain.common;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DomainCommon {

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    
}
