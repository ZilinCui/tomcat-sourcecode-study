package top.cuizilin.studytest;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.net.URLClassLoader;
import java.security.CodeSource;

public class MainTest {
    public static void main(String[] args) throws MalformedURLException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        URL[] urls = new URL[]{new URL("file", "", "D:\\SOFT\\program\\sourceCodeStudy\\test\\tomcat-sourcecode-study\\webapp\\web\\WEB-INF\\classes\\top\\cuizilin\\servlet\\AServlet.class".replaceAll("\\\\", "/"))};

        SimpleClassLoader simpleClassLoader = new SimpleClassLoader(urls, null);
        Class<?> aClass = simpleClassLoader.loadClass("top.cuizilin.servlet.AServlet");
        aClass.getConstructor().newInstance();
    }
}

class SimpleClassLoader extends URLClassLoader{

    private ClassLoader system = getSystemClassLoader();

    public SimpleClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public Class<?> loadClass(String name){
       Class clazz = null;

        try {
            clazz = system.loadClass(name);
            if(clazz != null){
                return clazz;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("System not found the class");
        }

        try {
            FileInputStream in = new FileInputStream("D:\\SOFT\\program\\sourceCodeStudy\\test\\tomcat-sourcecode-study\\webapp\\web\\WEB-INF\\classes\\top\\cuizilin\\servlet\\AServlet.class");
            byte[] b = in.readAllBytes();
            clazz = defineClass("top.cuizilin.servlet.AServlet", b, 0, b.length);
            if(clazz != null){
                return clazz;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}