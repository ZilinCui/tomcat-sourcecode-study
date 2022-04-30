package top.cuizilin.study.loader;

import java.net.URL;
import java.net.URLClassLoader;

public class SimpleWebappClassLoader extends URLClassLoader {

    private ClassLoader system = getSystemClassLoader();

    public SimpleWebappClassLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    @Override
    public Class<?> loadClass(String name){
        Class clazz = null;

        //first check the whether the class has been loaded before
        clazz = findLoadedClass(name);
        if(clazz != null){
            return clazz;
        }

        //second check if the system classloader load the class
        try {
            clazz = system.loadClass(name);
            if(clazz != null){
                return clazz;
            }
        } catch (ClassNotFoundException e) {
            System.out.println("System not found the class");
        }

        //Finally, find the class in the WEB-INF/classes folder and the WEB-INF/lib folder
        try {
            return super.loadClass(name);
        } catch (ClassNotFoundException e) {
            System.out.println("found the class in repo");
        }
        return null;

    }
}
