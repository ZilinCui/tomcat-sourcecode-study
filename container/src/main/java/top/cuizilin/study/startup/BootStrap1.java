package top.cuizilin.study.startup;

import org.apache.catalina.Loader;
import org.apache.catalina.Pipeline;
import org.apache.catalina.Valve;
import org.apache.catalina.Wrapper;
import top.cuizilin.study.connector.http.HttpConnector;
import top.cuizilin.study.core.SimpleLoader;
import top.cuizilin.study.core.SimpleWrapper;
import top.cuizilin.study.vavles.ClientIPLoggerValve;
import top.cuizilin.study.vavles.HeaderLoggerValve;

public final class BootStrap1 {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        Wrapper wrapper = new SimpleWrapper();
        wrapper.setServletClass("ModernServlet");
        Loader loader = new SimpleLoader();
        Valve valve1 = new ClientIPLoggerValve();
        Valve valve2 = new HeaderLoggerValve();
        wrapper.setLoader(loader);
        ((Pipeline)wrapper).addValve(valve1);
        ((Pipeline)wrapper).addValve(valve2);
        connector.setContainer(wrapper);
        connector.start();
    }
}
