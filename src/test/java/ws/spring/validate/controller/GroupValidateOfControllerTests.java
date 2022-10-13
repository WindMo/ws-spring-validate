package ws.spring.validate.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ws.spring.validate.WsSpringValidateApplicationTests;
import ws.spring.validate.pojo.Pot;
import ws.spring.validate.util.JacksonUtils;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author WindShadow
 * @version 2022-10-14.
 * @see GroupValidateOfController
 */

@AutoConfigureMockMvc
public class GroupValidateOfControllerTests extends WsSpringValidateApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void groupValidateForDgspTest() throws Exception {

        dgspTest("/validated/group/dgsp/bean", new Pot(0, "123456", null, 1));
        dgspTest("/validated/group/dgsp/bean", new Pot(0, "123456", "blue", 1));
        dgspTest("/validated/group/dgsp/bean", new Pot(2, "123456", null, 1));
        dgspTest("/validated/group/dgsp/bean", new Pot(2, "123456", "blue", 1));
    }

    private void dgspTest(String uri, Pot pot) {

        try {
            mvc.perform(post(uri)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(JacksonUtils.toJson(pot)))
                    .andExpect(status().isBadRequest());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
