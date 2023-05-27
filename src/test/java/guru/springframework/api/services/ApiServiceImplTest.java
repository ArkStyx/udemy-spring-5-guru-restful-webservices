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

    private static final int RESULTAT_ATTENDU_APIFAKETORY_PRODUCTION = 4;
    private static final int RESULTAT_ATTENDU_APIFAKETORY_MOCK_SERVER = 1;
    
    @Test
    public void getUsersApiFaketoryProduction() throws Exception {
        List<User> users = apiService.getUsersApiFaketoryProduction(3);
        assertNotNull(apiService);
        assertEquals(RESULTAT_ATTENDU_APIFAKETORY_PRODUCTION, users.size());
    }
    
    @Test
    public void getUsersApiFaketoryMockServer() throws Exception {
        List<User> users = apiService.getUsersApiFaketoryMockServer(3);
        assertNotNull(apiService);
        assertEquals(RESULTAT_ATTENDU_APIFAKETORY_MOCK_SERVER, users.size());
    }
    
}
