package guru.springframework.api.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import guru.springframework.api.domain.User;

public class ApiServiceImplTest_V02 {

	@Mock
    private ApiService apiService;
    
    @BeforeEach
    public void setUp() throws Exception {
		MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetUsers() throws Exception {
        List<User> users = apiService.getUsers(3);
        assertNotNull(apiService);
        assertEquals(4, users.size());
    }
}
