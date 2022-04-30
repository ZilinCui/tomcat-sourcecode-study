package top.cuizilin.study.startup;


import org.apache.catalina.*;
import top.cuizilin.study.connector.http.HttpConnector;
import top.cuizilin.study.core.*;
import top.cuizilin.study.loader.SimpleWebappLoader;
import top.cuizilin.study.logger.FileLogger;

public final class BootStrap {
    public static void main(String[] args) {
        Wrapper wrapper1 = new SimpleWrapper();
        wrapper1.setName("Primitive");
        wrapper1.setServletClass("PrimitiveServlet");

        Wrapper wrapper2 = new SimpleWrapper();
        wrapper2.setName("Modern");
        wrapper2.setServletClass("ModernServlet");

        Wrapper wrapper3 = new SimpleWrapper();
        wrapper3.setName("AServlet");
        wrapper3.setServletClass("top.cuizilin.webdemo.AServlet");

        Context context = new SimpleContext();
        context.addChild(wrapper1);
        context.addChild(wrapper2);
        context.addChild(wrapper3);

        Mapper mapper = new SimpleContextMapper();
        mapper.setProtocol("http");
        context.addMapper(mapper);

        LifecycleListener listener = new SimpleContextLifecycleListener();
        ((Lifecycle) context).addLifecycleListener(listener);

        SimpleWebappLoader loader = new SimpleWebappLoader();
        context.setLoader(loader);


        // context.addServletMapping(pattern, name);
        context.addServletMapping("/Primitive", "Primitive");
        context.addServletMapping("/Modern", "Modern");
        context.addServletMapping("/AServlet", "AServlet");

        // ------ add logger --------
        System.setProperty("catalina.base", System.getProperty("user.dir"));
        FileLogger logger = new FileLogger();
        logger.setPrefix("FileLog_");
        logger.setSuffix(".txt");
        logger.setTimestamp(true);
        logger.setDirectory("D:\\SOFT\\program\\sourceCodeStudy\\study\\container\\webroot");
        context.setLogger(logger);

        HttpConnector connector = new HttpConnector();

        connector.setContainer(context);
        try {
            connector.start();
            ((Lifecycle) context).start();

            // make the application wait until we press a key.
            System.in.read();
            ((Lifecycle) context).stop();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
