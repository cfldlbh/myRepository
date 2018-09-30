package com.lbh.cfld.test;

import com.lbh.cfld.controller.UserController;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

import java.io.*;
import java.util.Random;

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
    public void removeComments(File javaFile) throws IOException {
        if(!javaFile.exists()){
            System.out.println("文件不存在");
            return ;
        }
        BufferedReader bufferedReader = new BufferedReader(new FileReader(javaFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(javaFile));
        while (true){
            String line = bufferedReader.readLine();
            if(line==null){
                break;
            }
            if(!line.startsWith("//")){
                writer.write(line);
                writer.newLine();
            }
        }
        bufferedReader.close();
        writer.flush();
        writer.close();

    }
    @Test
    public void testWriter() throws IOException {
        removeComments(new File("d:/123.java"));
    }
    @Test
    public void testStream() throws IOException, ClassNotFoundException {
        FileOutputStream filterOutputStream = new FileOutputStream(new File("d:/hero.txt"));
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(filterOutputStream);
        objectOutputStream.writeObject(new hero());
        filterOutputStream.close();
        objectOutputStream.close();
        FileInputStream fileInputStream = new FileInputStream(new File("d:/hero.txt"));
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        hero o =(hero) objectInputStream.readObject();
        System.out.println(o.name);
    }
    @Test
    public void pj(){
        String mima = ""+random()+random()+random();

    }
    public static char random(){
        String str = "0123456789qazwsxedcrfvtgbyhnujmikolpQAZWSXEDCRFVTGBYHNUJMIKOLP";
        char c = str.charAt(new Random().nextInt(str.length()));
        return c;
    }
    public static void pa(String ym){

    }
    @Test
    public void adbTest() throws InterruptedException {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        new Thread(new ABCThread(c,b,"A")).start();
        Thread.sleep(300);
        new Thread(new ABCThread(a,c,"B")).start();
        Thread.sleep(300);
        new Thread(new ABCThread(b,a,"C")).start();
    }
}
