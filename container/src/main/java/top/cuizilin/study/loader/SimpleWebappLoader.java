package top.cuizilin.study.loader;

import org.apache.catalina.Container;
import org.apache.catalina.DefaultContext;
import org.apache.catalina.Loader;
import org.apache.catalina.loader.WebappClassLoader;

import java.beans.PropertyChangeListener;
import java.net.MalformedURLException;
import java.net.URL;

public class SimpleWebappLoader implements Loader {


    public static String classpath = "D:\\SOFT\\program\\sourceCodeStudy\\webdemo\\web\\WEB-INF\\classes\\".replaceAll("\\\\", "/");
    public static String jarpath = "D:\\SOFT\\program\\sourceCodeStudy\\webdemo\\web\\WEB-INF\\lib\\mysql-connector-java-5.1.43.jar";


    @Override
    public ClassLoader getClassLoader() {
        try {
            URL classpathURL = new URL("file", "", classpath);
            URL jarpathURL = new URL("file", "", jarpath);
            URL[] urls = new URL[]{classpathURL, jarpathURL};
            return new SimpleWebappClassLoader(urls, null);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Container getContainer() {
       return null;
    }

    @Override
    public void setContainer(Container container) {

    }

    @Override
    public DefaultContext getDefaultContext() {
        return null;
    }

    @Override
    public void setDefaultContext(DefaultContext defaultContext) {

    }

    @Override
    public boolean getDelegate() {
        return false;
    }

    @Override
    public void setDelegate(boolean b) {

    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public boolean getReloadable() {
        return false;
    }

    @Override
    public void setReloadable(boolean b) {

    }

    @Override
    public void addPropertyChangeListener(PropertyChangeListener propertyChangeListener) {

    }

    @Override
    public void addRepository(String s) {

    }

    @Override
    public String[] findRepositories() {
        return new String[0];
    }

    @Override
    public boolean modified() {
        return false;
    }

    @Override
    public void removePropertyChangeListener(PropertyChangeListener propertyChangeListener) {

    }
}
