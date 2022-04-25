package top.cuizilin.study.startup;

import top.cuizilin.study.connector.http.HttpConnector;
import top.cuizilin.study.core.SimpleContainer;

public class BootStrap {
    public static void main(String[] args){
        HttpConnector connector = new HttpConnector();
        SimpleContainer container = new SimpleContainer();
        connector.setContainer(container);
        try {
            connector.start();

            // make the application wait until we press any key.
            System.in.read();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
