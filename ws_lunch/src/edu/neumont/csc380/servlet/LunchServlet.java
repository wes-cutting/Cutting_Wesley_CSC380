package edu.neumont.csc380.servlet;

import edu.neumont.csc380.service.LunchServiceImpl;
import org.apache.cxf.Bus;
import org.apache.cxf.BusFactory;
import org.apache.cxf.transport.servlet.CXFNonSpringServlet;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.xml.ws.Endpoint;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/9/13
 * Time: 3:59 PM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet("/lunch/*")
public class LunchServlet extends CXFNonSpringServlet {
    @Override
    protected void loadBus(ServletConfig sc) {
        super.loadBus(sc);

        Bus bus = getBus();
        BusFactory.setDefaultBus(bus);
        Endpoint.publish("/LunchService", new LunchServiceImpl());
    }
}
