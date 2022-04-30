package top.cuizilin.study.core;

import org.apache.catalina.*;

import javax.servlet.ServletException;
import java.io.IOException;

public class SimplePipeline implements Pipeline, Lifecycle {

    protected Container container;

    protected Valve basic;

    protected Valve[] valves = new Valve[0];

    public void setContainer(Container container){
        this.container = container;
    }

    public SimplePipeline(Container container){
       setContainer(container);
    }

    @Override
    public Valve getBasic() {
        return basic;
    }

    @Override
    public void setBasic(Valve valve) {
        this.basic = valve;
        ((Contained) valve).setContainer(this.container);
    }

    @Override
    public void addValve(Valve valve) {
        if(valve instanceof Contained){
            ((Contained)valve).setContainer(container);
        }
        synchronized(valves){
            Valve[] results = new Valve[valves.length+1];
            System.arraycopy(valves, 0, results ,0, valves.length);
            results[valves.length] = valve;
            valves = results;
        }

    }

    @Override
    public Valve[] getValves() {
        return valves;
    }

    @Override
    public void invoke(Request request, Response response) throws IOException, ServletException {
        (new SimplePipelineValveContext()).invokeNext(request, response);
    }

    @Override
    public void removeValve(Valve valve) {

    }

    @Override
    public void addLifecycleListener(LifecycleListener listener) {

    }

    @Override
    public LifecycleListener[] findLifecycleListeners() {
        return new LifecycleListener[0];
    }


    @Override
    public void removeLifecycleListener(LifecycleListener listener) {

    }

    @Override
    public void start() throws LifecycleException {

    }

    @Override
    public void stop() throws LifecycleException {

    }

    protected class SimplePipelineValveContext implements ValveContext{

        protected int stage = 0;

        @Override
        public String getInfo() {
            return null;
        }

        @Override
        public void invokeNext(Request request, Response response) throws IOException, ServletException {
            int subscript = stage++;
            if(subscript < valves.length){
                valves[subscript].invoke(request, response, this);
            }else if(subscript == valves.length && basic != null){
                basic.invoke(request, response, this);
            }
        }
    }
}
