package generated.service.client;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.6
 * 2013-08-10T14:57:53.520-06:00
 * Generated source version: 2.7.6
 * 
 */
@WebService(targetNamespace = "http://localhost/Lunch", name = "LunchService")
@XmlSeeAlso({ObjectFactory.class})
public interface LunchService {

    @RequestWrapper(localName = "addRestaurant", targetNamespace = "http://localhost/Lunch", className = "generated.service.client.AddRestaurant")
    @WebMethod
    @ResponseWrapper(localName = "addRestaurantResponse", targetNamespace = "http://localhost/Lunch", className = "generated.service.client.AddRestaurantResponse")
    public void addRestaurant(
        @WebParam(name = "restaurant", targetNamespace = "")
        generated.service.client.Restaurant restaurant
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "placeOrder", targetNamespace = "http://localhost/Lunch", className = "generated.service.client.PlaceOrder")
    @WebMethod
    @ResponseWrapper(localName = "placeOrderResponse", targetNamespace = "http://localhost/Lunch", className = "generated.service.client.PlaceOrderResponse")
    public boolean placeOrder(
        @WebParam(name = "restaurantName", targetNamespace = "")
        java.lang.String restaurantName,
        @WebParam(name = "studentName", targetNamespace = "")
        java.lang.String studentName,
        @WebParam(name = "selections", targetNamespace = "")
        java.util.List<java.lang.String> selections
    );

    @WebResult(name = "MenuItems", targetNamespace = "")
    @RequestWrapper(localName = "getMenuItems", targetNamespace = "http://localhost/Lunch", className = "generated.service.client.GetMenuItems")
    @WebMethod
    @ResponseWrapper(localName = "getMenuItemsResponse", targetNamespace = "http://localhost/Lunch", className = "generated.service.client.GetMenuItemsResponse")
    public java.util.List<java.lang.String> getMenuItems(
        @WebParam(name = "restaurant", targetNamespace = "")
        generated.service.client.Restaurant restaurant
    );

    @WebResult(name = "Restaurants", targetNamespace = "")
    @RequestWrapper(localName = "getRestaurants", targetNamespace = "http://localhost/Lunch", className = "generated.service.client.GetRestaurants")
    @WebMethod
    @ResponseWrapper(localName = "getRestaurantsResponse", targetNamespace = "http://localhost/Lunch", className = "generated.service.client.GetRestaurantsResponse")
    public java.util.List<generated.service.client.Restaurant> getRestaurants();
}
