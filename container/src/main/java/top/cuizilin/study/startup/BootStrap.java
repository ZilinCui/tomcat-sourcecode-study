package top.cuizilin.study.startup;


import org.apache.catalina.*;
import org.apache.catalina.connector.http.HttpConnector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.loader.WebappClassLoader;
import org.apache.catalina.loader.WebappLoader;
import org.apache.naming.resources.ProxyDirContext;
import top.cuizilin.study.core.*;
import top.cuizilin.study.loader.SimpleWebappLoader;
import top.cuizilin.study.logger.FileLogger;

public final class BootStrap {
    public static void main(String[] args) {

        System.setProperty("catalina.base", System.getProperty("user.dir"));
        Connector connector = new HttpConnector();
        Wrapper wrapper1 = new SimpleWrapper();
        wrapper1.setName("AServlet");
        wrapper1.setServletClass("top.cuizilin.servlet.AServlet");


        Context context = new StandardContext();
        // StandardContext's start method adds a default mapper
        context.setPath("webapp/web");
        context.setDocBase("webapp/web");

        context.addChild(wrapper1);

        context.addServletMapping("/AServlet", "AServlet");
        // add ContextConfig. This listener is important because it configures
        // StandardContext (sets configured to true), otherwise StandardContext
        // won't start
        LifecycleListener listener = new SimpleContextConfig();
        ((Lifecycle) context).addLifecycleListener(listener);

        // here is our loader
        Loader loader = new WebappLoader();
        // associate the loader with the Context
        context.setLoader(loader);

        connector.setContainer(context);

        try {
            connector.initialize();
            ((Lifecycle) connector).start();
            ((Lifecycle) context).start();
            // now we want to know some details about WebappLoader
            WebappClassLoader classLoader = (WebappClassLoader) loader.getClassLoader();
            System.out.println("Resources' docBase: " + ((ProxyDirContext)classLoader.getResources()).getDocBase());
            String[] repositories = classLoader.findRepositories();
            for (int i=0; i<repositories.length; i++) {
                System.out.println("  repository: " + repositories[i]);
            }

            // make the application wait until we press a key.
            System.in.read();
            ((Lifecycle) context).stop();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
