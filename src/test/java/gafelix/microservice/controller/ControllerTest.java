package gafelix.microservice.controller;

import gafelix.microservice.repository.UserRepository;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @SneakyThrows
    public void shouldCreateNewUser() {
        var form = "{\"name\": \"Gabriel\"," +
                "\"email\": \"gabriel@email.com\"," +
                "\"address\":" +
                "[{\"country\": \"Brazil\"," +
                "\"state\": \"SP\"," +
                "\"county\": \"São Paulo\"," +
                "\"zipCode\": \"00000-000\"," +
                "\"street\": \"Minha rua\"}]," +
                "\"cpf\": \"000.000.000-00\"," +
                "\"pis\": \"00.00000.00-0\"," +
                "\"password\": \"123456\"}";
        mockMvc.perform(MockMvcRequestBuilders
                .post("/user")
                .content(form)
                .contentType("application/json"))
                .andExpect(status().isCreated())
                .andExpect(content().json(form));
    }

    @Test
    @SneakyThrows
    public void shouldGetCreatedUser() {
        var response = "{\"id\":1," +
                "\"name\":\"Gabriel\"," +
                "\"email\":\"gabriel@email.com\"," +
                "\"address\":[{\"id\":2," +
                "\"country\":\"Brazil\"," +
                "\"state\":\"SP\"," +
                "\"county\":\"São Paulo\"," +
                "\"zipCode\":\"00000-000\"," +
                "\"street\":\"Minha rua\"," +
                "\"streetNumber\":null," +
                "\"extra\":null}]," +
                "\"cpf\":\"000.000.000-00\"," +
                "\"pis\":\"00.00000.00-0\"}";
        mockMvc.perform(MockMvcRequestBuilders
                .get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(response));
    }

    @Test
    @SneakyThrows
    public void shouldDeleteCreatedUser() {
        mockMvc.perform(MockMvcRequestBuilders
                .delete("/user/5"))
                .andExpect(status().isNoContent());
    }

}