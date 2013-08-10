package edu.neumont.csc380.service;

import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/9/13
 * Time: 3:45 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(endpointInterface = "edu.neumont.csc380.service.LunchService", serviceName = "LunchService")
public class LunchServiceImpl implements LunchService{

    private static final List<Restaurant> restaurants;
    private List<Order> orders;

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
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }

    @Override
    public List<String> getMenuItems(Restaurant restaurant) {
        return restaurants.get(restaurants.indexOf(restaurant)).getMenuItems();
    }

    @Override
    public boolean placeOrder(@WebParam(name = "restaurantName") String restaurantName, @WebParam(name = "studentName") String studentName, @WebParam(name = "selections") List<String> selections) {
        Order order = new Order();
        order.setRestaurantName(restaurantName);
        order.setStudentName(studentName);
        for(String s : selections){
            order.addSelection(s);
        }
        if(orders == null){
            orders = new ArrayList<Order>();
        }
        orders.add(order);
        return true;
    }


    @Override
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
}
