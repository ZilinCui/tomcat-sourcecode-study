
import javax.servlet.*;
import java.io.IOException;

public class PrimitiveServlet implements Servlet {

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {

    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service method init");
        String errorMessage = "HTTP/1.1 200\n" +
                "Content-Type: text/html\r\n" +
                "\n" +
                "<h1>The PrimitiveServlet service method init</h1>";
        servletResponse.getWriter().println(errorMessage);
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }
}