package com.lbh.cfld.test;

import com.lbh.cfld.controller.UserController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class ControllerTest {
    @Test
    public void userTest() throws Exception {
        UserController userController = new UserController();
        MockMvc build = standaloneSetup(userController).build();
        build.perform(get("/user/test")).andExpect(view().name("user/test"));
    }
    @Test
    public void loginTest(){
        UserController userController = new UserController();

    }
}
