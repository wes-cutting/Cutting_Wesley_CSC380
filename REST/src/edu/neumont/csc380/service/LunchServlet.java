package edu.neumont.csc380.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/12/13
 * Time: 12:36 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "LunchServlet", urlPatterns = "/lunch")
public class LunchServlet {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String returnTitle(){
        return "<p>Lunch is served</p>";
    }
}
