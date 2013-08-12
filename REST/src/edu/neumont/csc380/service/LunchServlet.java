package edu.neumont.csc380.service;

import javax.jws.WebMethod;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/12/13
 * Time: 12:36 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "LunchServlet", urlPatterns = "/lunch")
public class LunchServlet extends HttpServlet{

    private static final List<Restaurant> restaurants;

    static{
        restaurants = new ArrayList<Restaurant>();
        Restaurant r1 = new Restaurant();
        r1.setName("Chick-fil-a");
        r1.addMenuItem("Chicken Sammich");
        r1.addMenuItem("Waffle Fries");
        Restaurant r2 = new Restaurant();
        r2.setName("Red Hot");
        r2.addMenuItem("5th Ave.");
        r2.addMenuItem("Chili Dog");
        r2.addMenuItem("Kraut Dog");
        Restaurant r3 = new Restaurant();
        r3.setName("iHop");
        r3.addMenuItem("Pancakes");
        r3.addMenuItem("Bacon & Eggs");
        r3.addMenuItem("Coffee");
        r3.addMenuItem("Omelet");
        restaurants.add(r1);
        restaurants.add(r2);
        restaurants.add(r3);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        for(Restaurant r: restaurants){
            out.println(r.toString());
        }

    }
}
