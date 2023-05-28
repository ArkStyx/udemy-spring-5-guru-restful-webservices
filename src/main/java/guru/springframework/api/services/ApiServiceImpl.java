package guru.springframework.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserList;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ApiServiceImpl implements ApiService {

	private final String restTemplateApiUrl;
	private final String restTemplateApiQueryParam;

	private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate,
    						@Value("${rest.template.api.url}") String restTemplateApiUrl, 
    						@Value("${rest.template.api.query.param}") String restTemplateApiQueryParam) {
        this.restTemplate = restTemplate;
        this.restTemplateApiUrl = restTemplateApiUrl;
        this.restTemplateApiQueryParam = restTemplateApiQueryParam;
    }

	@Override
	public List<User> getUsers(Integer limit) {
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromUriString(restTemplateApiUrl)
        																.queryParam(restTemplateApiQueryParam, limit);

        UserList listeUtilisateur = restTemplate.getForObject(uriComponentsBuilder.toUriString(), UserList.class);

        List<User> userData = listeUtilisateur.getUserList();
        return userData;
	}

    @Override
    public Flux<User> getUsers(Mono<Integer> limit) {
    	
    	// TODO FIXME Type safety: The expression of type Flux needs unchecked conversion to conform to Flux<User>
//        return WebClient.create(restTemplateApiUrl)
//                .get()
//                .uri(uriBuilder -> uriBuilder.queryParam(restTemplateApiQueryParam, limit.toProcessor().block()).build())
//                .accept(MediaType.APPLICATION_JSON)
//                .exchange()
//                .flatMap(resp -> resp.bodyToMono(List.class))
//                .flatMapIterable(list -> list);
    	
    	// TODO FIXME
    	return Flux.empty();
    }
    
}
