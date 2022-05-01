package top.cuizilin.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class AServlet extends HttpServlet {

    static {
        System.out.println("Load the AServlet Class");
    }

    public AServlet(){
        System.out.println("AServlet constructor init");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello World");
        resp.getWriter().println("Hello World");
    }
}
