package top.cuizilin.study.startup;

import org.apache.catalina.*;
import top.cuizilin.study.connector.http.HttpConnector;
import top.cuizilin.study.core.*;
import top.cuizilin.study.vavles.ClientIPLoggerValve;
import top.cuizilin.study.vavles.HeaderLoggerValve;

public final class BootStrap2 {
    public static void main(String[] args) {
        HttpConnector connector = new HttpConnector();
        Wrapper wrapper1 = new SimpleWrapper();
        wrapper1.setName("Primitive");
        wrapper1.setServletClass("PrimitiveServlet");
        Wrapper wrapper2 = new SimpleWrapper();
        wrapper2.setName("Modern");
        wrapper2.setServletClass("ModernServlet");
        Context context = new SimpleContext();
        context.addChild(wrapper1);
        context.addChild(wrapper2);
        SimpleContextValve simpleContextValve = new SimpleContextValve();
        ((Pipeline) context).setBasic(simpleContextValve);

        Valve valve1 = new HeaderLoggerValve();
        Valve valve2 = new ClientIPLoggerValve();

        ((Pipeline) context).addValve(valve1);
        ((Pipeline) context).addValve(valve2);

        Mapper mapper = new SimpleContextMapper();
        mapper.setProtocol("http");
        context.addMapper(mapper);

        Loader loader = new SimpleLoader();
        context.setLoader(loader);
        // context.addServletMapping(pattern, name);
        context.addServletMapping("/servlet/Primitive", "Primitive");
        context.addServletMapping("/servlet/Modern", "Modern");
        connector.setContainer(context);
        try {
            connector.start();

            // make the application wait until we press a key.
            System.in.read();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
