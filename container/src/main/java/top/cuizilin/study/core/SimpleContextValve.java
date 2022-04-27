package top.cuizilin.study.core;

import org.apache.catalina.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SimpleContextValve implements Valve, Contained {

    protected Container container;

    @Override
    public Container getContainer() {
        return container;
    }

    @Override
    public void setContainer(Container container) {
        this.container = container;
    }

    @Override
    public String getInfo() {
        return null;
    }

    @Override
    public void invoke(Request request, Response response, ValveContext valveContext) throws IOException, ServletException {
        if (!(request.getRequest() instanceof HttpServletRequest)
                || !(response.getResponse() instanceof HttpServletResponse)) {
            return; // NOTE - Not much else we can do generically
        }
        // Disallow any direct access to resources under WEB-INF or META-INF
        Context context = (Context) getContainer();

        // Select the Wrapper to be used for this Request

        Wrapper wrapper = (Wrapper) context.map(request, true);

        // Ask this Wrapper to process this Request
        if(wrapper != null)
            wrapper.invoke(request, response);


    }
    private void badRequest(String requestURI, HttpServletResponse response) {
        try {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, requestURI);
        } catch (IllegalStateException e) {
            ;
        } catch (IOException e) {
            ;
        }
    }

    private void notFound(String requestURI, HttpServletResponse response) {
        try {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, requestURI);
        } catch (IllegalStateException e) {
            ;
        } catch (IOException e) {
            ;
        }
    }
}
