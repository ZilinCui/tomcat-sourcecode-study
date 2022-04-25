package top.cuizilin.study.connector.http;

import org.apache.catalina.Container;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Stack;

public class HttpConnector implements Runnable{

    int maxProcessors = 20;

    int currentProcessors;

    private Container container;

    public void setContainer(Container container){
        this.container = container;
    }

    public Container getContainer(){
       return this.container;
    }

    private boolean stopped;

    Stack<HttpProcessor> processors = new Stack<>();


    public void start(){
        new Thread(this).start();
    }

    @Override
    public void run() {
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(8080);
            while(!stopped){
                Socket socket = serverSocket.accept();

                HttpProcessor httpProcessor = createProcessors();
                if(httpProcessor == null){
                   socket.close();
                   continue;
                }
                httpProcessor.assign(socket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void recycle(HttpProcessor httpProcessor){
        processors.push(httpProcessor);
    }

    public HttpProcessor createProcessors(){
       synchronized(processors){
           if(processors.size() > 0){
               return processors.pop();
           }
           if(currentProcessors < maxProcessors){
                HttpProcessor httpProcessor = new HttpProcessor(this);
                currentProcessors++;
                new Thread(httpProcessor).start();
                return httpProcessor;
           }else{
               return null;
           }
       }

    }
}
