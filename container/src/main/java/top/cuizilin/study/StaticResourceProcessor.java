package top.cuizilin.study;

import top.cuizilin.study.connector.http.HttpRequest;
import top.cuizilin.study.connector.http.HttpResponse;

import java.io.IOException;

public class StaticResourceProcessor {
    public void process(HttpRequest request, HttpResponse response) {
        try {
            response.sendStaticResource();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
