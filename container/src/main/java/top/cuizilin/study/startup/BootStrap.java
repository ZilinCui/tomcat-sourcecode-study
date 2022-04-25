package top.cuizilin.study.startup;

import top.cuizilin.study.connector.http.HttpConnector;

public class BootStrap {
    public static void main(String[] args){
        new Thread(new HttpConnector()).start();
    }
}
