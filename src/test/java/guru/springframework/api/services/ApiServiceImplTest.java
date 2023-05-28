package guru.springframework.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import guru.springframework.api.domain.User;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    private ApiService apiService;

    private static final int RESULTAT_ATTENDU_JSON_PLACE_HOLDER = 3;
    
    @Test
    public void getUsers() throws Exception {
        List<User> users = apiService.getUsers(3);
        assertNotNull(apiService);
        assertEquals(RESULTAT_ATTENDU_JSON_PLACE_HOLDER, users.size());
    }
    
}
