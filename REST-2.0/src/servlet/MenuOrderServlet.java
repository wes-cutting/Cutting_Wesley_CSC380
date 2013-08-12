package servlet;

import jaxb.menu.Item;
import jaxb.menu.Restaurant;
import jaxb.order.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/12/13
 * Time: 10:47 AM
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "MenuOrderServlet", urlPatterns = "/menu")
public class MenuOrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JAXBContext orderContext = JAXBContext.newInstance(Order.class);
            InputStream inputStream = request.getInputStream();
            Order order = (Order) orderContext.createUnmarshaller().unmarshal(inputStream);

            response.getWriter().println("Order for " + order.getItem().get(0).getQuantity() + " "+ order.getItem().get(0).getName() + " received");

        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JAXBContext menuContext = JAXBContext.newInstance(Restaurant.class);
            jaxb.menu.Restaurant restaurant = new jaxb.menu.Restaurant();
            Integer restaurantId = Integer.parseInt(request.getParameter("restaurantId"));

            if(restaurantId == 1){
                Item item1 = new Item();
                item1.setName("Bacon");
                item1.setPrice(new BigDecimal(1.00));
                restaurant.addItem(item1);

                Item item2 = new Item();
                item2.setName("Eggs");
                item2.setPrice(new BigDecimal(2.00));
                restaurant.addItem(item2);
            }
            else{
                Item item1 = new Item();
                item1.setName("Steak");
                item1.setPrice(new BigDecimal(12.00));
                restaurant.addItem(item1);

                Item item2 = new Item();
                item2.setName("Potatoes");
                item2.setPrice(new BigDecimal(3.00));
                restaurant.addItem(item2);
            }

            menuContext.createMarshaller().marshal(restaurant, response.getOutputStream());

        } catch (JAXBException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
