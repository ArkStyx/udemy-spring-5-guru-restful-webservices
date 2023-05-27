package guru.springframework.api.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import guru.springframework.api.domain.User;
import guru.springframework.api.domain.UserData;

@Service
public class ApiServiceImpl implements ApiService {

	private static final String APIFAKETORY_URL_PRODUCTION = "http://apifaketory.com/api/user?limit=";
	private static final String APIFAKETORY_URL_MOCK_SERVEUR = "http://private-anon-d95c2eca82-apifaketory.apiary-mock.com/api/user?limit=";

	private RestTemplate restTemplate;

    public ApiServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

	@Override
	public List<User> getUsersApiFaketoryProduction(Integer limit) {
        UserData userData = restTemplate.getForObject(APIFAKETORY_URL_PRODUCTION + limit, UserData.class);
        return userData.getData();
	}

    @Override
    public List<User> getUsersApiFaketoryMockServer(Integer limit) {
        UserData userData = restTemplate.getForObject(APIFAKETORY_URL_MOCK_SERVEUR + limit, UserData.class);
        return userData.getData();
    }
    
}
