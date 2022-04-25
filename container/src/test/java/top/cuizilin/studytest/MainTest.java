package top.cuizilin.studytest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

public class MainTest {
    public static void main(String[] args) {
        byte[] b = new byte[4096*4096];
        try {
            FileInputStream fis = new FileInputStream(
                    new File("C:\\Users\\Zilin Cui\\Desktop\\myblog.sql"));
            System.out.println(fis.available());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Object socket = new Object();

    public void setSocket(){
        this.socket = new Object();
    }

    public Object getSocket(){
       Object socket = this.socket;
       return socket;
    }
}
