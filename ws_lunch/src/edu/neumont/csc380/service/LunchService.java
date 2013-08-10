package edu.neumont.csc380.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/9/13
 * Time: 3:37 PM
 * To change this template use File | Settings | File Templates.
 */
@WebService(name = "LunchService", targetNamespace = "http://localhost/Lunch")
public interface LunchService {
    @WebMethod(operationName = "getRestaurants")
    public @WebResult(name = "Restaurants")List<Restaurant> getRestaurants();
    @WebMethod(operationName = "getMenuItems")
    public @WebResult(name = "MenuItems")List<String> getMenuItems(@WebParam(name = "restaurant")Restaurant restaurant);
    @WebMethod(operationName = "placeOrder")
    public boolean placeOrder(@WebParam(name = "restaurantName")String restaurantName,@WebParam(name = "studentName") String studentName,@WebParam(name = "selections") List<String> selections);
    @WebMethod(operationName = "addRestaurant")
    public void addRestaurant(@WebParam(name = "restaurant")Restaurant restaurant);
}
