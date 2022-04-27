package top.cuizilin.study.core;

import org.apache.catalina.*;

import javax.servlet.http.HttpServletRequest;

public class SimpleContextMapper implements Mapper {

    private SimpleContext context;



    @Override
    public Container getContainer() {
        return context;
    }

    @Override
    public void setContainer(Container container) {
        this.context = (SimpleContext) container;
    }

    @Override
    public String getProtocol() {
        return null;
    }

    @Override
    public void setProtocol(String protocol) {

    }

    @Override
    public Container map(Request request, boolean update) {
        String requestURI = ((HttpServletRequest) request.getRequest()).getRequestURI();
        // Apply the standard request URI mapping rules from the specification
        Wrapper wrapper = null;
        String name = context.findServletMapping(requestURI);
        if (name != null)
            wrapper = (Wrapper) context.findChild(name);
        return (wrapper);
    }
}
