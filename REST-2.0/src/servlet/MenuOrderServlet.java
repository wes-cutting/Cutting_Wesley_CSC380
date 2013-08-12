package servlet;

import jaxb.restaurants.Restaurant;
import jaxb.restaurants.Restaurants;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/12/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "MenuOrderServlet")
public class MenuOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JAXBContext menuContext = JAXBContext.newInstance(Restaurant.class);
            Integer restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

            Restaurants restaurants = new Restaurants();
            Restaurant one = new Restaurant();
            one.setId(1);
            one.setName("McDonald's");
            restaurants.getRestaurant().add(one);
            Restaurant two = new Restaurant();
            two.setId(2);
            two.setName("Arby's");
            restaurants.getRestaurant().add(two);

            Restaurant restaurant = restaurants.getRestaurant().get(restaurantId);


            menuContext.createMarshaller().marshal(restaurant, response.getOutputStream());

        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
