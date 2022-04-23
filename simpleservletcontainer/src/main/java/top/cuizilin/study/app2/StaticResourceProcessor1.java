package top.cuizilin.study.app2;

import java.io.IOException;

public class StaticResourceProcessor1 {
    public void process(Request request, Response response) {
        try {
            response.sendStaticResource();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
