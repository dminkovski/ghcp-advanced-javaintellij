package microsoft.ghcp.advanced.GHCPDemo;

import microsoft.ghcp.advanced.GHCPDemo.controllers.UsersController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.springframework.http.MediaType;

/**
 * This class will perform unit tests for the UsersController.
 * MockMvc will be used to test the controller.
 */
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
public class UsersControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetAllUsers() throws Exception {
        // Perform a GET request to the /users endpoint
        mockMvc.perform(get("/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].username").value("john_doe"));
    }
}
