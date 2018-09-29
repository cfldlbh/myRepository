package com.lbh.cfld.test;

import com.lbh.cfld.controller.UserController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.io.*;

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
    @Test
    public void filetest() throws IOException {
        File file = new File("d:/fileTest.txt");
        FileWriter fileWriter = new FileWriter(file);
        char j = 'a';
        for(int i=0;i<9;i++){
            fileWriter.write(i+j);
        }
        fileWriter.close();
    }
    @Test
    public  void encodeFile() throws IOException {
        File file = new File("d:/fileTest.txt");
        File file1 = new File("d:/fileTest2.txt");
        FileReader fileReader = new FileReader(file);
        FileWriter fileWriter = new FileWriter(file1);
        char[] c =new char[1];
        while ((fileReader.read(c))!=-1){
            if(c[0]=='9'){
                c[0]=  '0';
            }else if(c[0]=='z'){
                c[0] = 'a';
            }else if(c[0]=='Z'){
                c[0] = 'A';
            }else {
                c[0]++;
            }

            fileWriter.write(c[0]);

        }
        fileReader.close();
        fileWriter.close();
    }
}
