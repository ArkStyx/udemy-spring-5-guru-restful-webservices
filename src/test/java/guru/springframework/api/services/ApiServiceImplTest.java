package guru.springframework.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.api.domain.User;

@SpringBootTest
public class ApiServiceImplTest {

    @Autowired
    private ApiService apiService;

    @Test
    public void testGetUsers() throws Exception {
        List<User> users = apiService.getUsers(3);
        assertNotNull(apiService);
        assertEquals(4, users.size());
    }
    
}
