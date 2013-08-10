
package generated.service.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the generated.service.client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetRestaurants_QNAME = new QName("http://localhost/Lunch", "getRestaurants");
    private final static QName _AddRestaurant_QNAME = new QName("http://localhost/Lunch", "addRestaurant");
    private final static QName _GetMenuItems_QNAME = new QName("http://localhost/Lunch", "getMenuItems");
    private final static QName _PlaceOrder_QNAME = new QName("http://localhost/Lunch", "placeOrder");
    private final static QName _PlaceOrderResponse_QNAME = new QName("http://localhost/Lunch", "placeOrderResponse");
    private final static QName _AddRestaurantResponse_QNAME = new QName("http://localhost/Lunch", "addRestaurantResponse");
    private final static QName _GetMenuItemsResponse_QNAME = new QName("http://localhost/Lunch", "getMenuItemsResponse");
    private final static QName _GetRestaurantsResponse_QNAME = new QName("http://localhost/Lunch", "getRestaurantsResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: generated.service.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddRestaurant }
     * 
     */
    public AddRestaurant createAddRestaurant() {
        return new AddRestaurant();
    }

    /**
     * Create an instance of {@link GetMenuItems }
     * 
     */
    public GetMenuItems createGetMenuItems() {
        return new GetMenuItems();
    }

    /**
     * Create an instance of {@link PlaceOrder }
     * 
     */
    public PlaceOrder createPlaceOrder() {
        return new PlaceOrder();
    }

    /**
     * Create an instance of {@link GetRestaurants }
     * 
     */
    public GetRestaurants createGetRestaurants() {
        return new GetRestaurants();
    }

    /**
     * Create an instance of {@link GetRestaurantsResponse }
     * 
     */
    public GetRestaurantsResponse createGetRestaurantsResponse() {
        return new GetRestaurantsResponse();
    }

    /**
     * Create an instance of {@link GetMenuItemsResponse }
     * 
     */
    public GetMenuItemsResponse createGetMenuItemsResponse() {
        return new GetMenuItemsResponse();
    }

    /**
     * Create an instance of {@link PlaceOrderResponse }
     * 
     */
    public PlaceOrderResponse createPlaceOrderResponse() {
        return new PlaceOrderResponse();
    }

    /**
     * Create an instance of {@link AddRestaurantResponse }
     * 
     */
    public AddRestaurantResponse createAddRestaurantResponse() {
        return new AddRestaurantResponse();
    }

    /**
     * Create an instance of {@link Restaurant }
     * 
     */
    public Restaurant createRestaurant() {
        return new Restaurant();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurants }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/Lunch", name = "getRestaurants")
    public JAXBElement<GetRestaurants> createGetRestaurants(GetRestaurants value) {
        return new JAXBElement<GetRestaurants>(_GetRestaurants_QNAME, GetRestaurants.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRestaurant }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/Lunch", name = "addRestaurant")
    public JAXBElement<AddRestaurant> createAddRestaurant(AddRestaurant value) {
        return new JAXBElement<AddRestaurant>(_AddRestaurant_QNAME, AddRestaurant.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenuItems }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/Lunch", name = "getMenuItems")
    public JAXBElement<GetMenuItems> createGetMenuItems(GetMenuItems value) {
        return new JAXBElement<GetMenuItems>(_GetMenuItems_QNAME, GetMenuItems.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrder }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/Lunch", name = "placeOrder")
    public JAXBElement<PlaceOrder> createPlaceOrder(PlaceOrder value) {
        return new JAXBElement<PlaceOrder>(_PlaceOrder_QNAME, PlaceOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PlaceOrderResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/Lunch", name = "placeOrderResponse")
    public JAXBElement<PlaceOrderResponse> createPlaceOrderResponse(PlaceOrderResponse value) {
        return new JAXBElement<PlaceOrderResponse>(_PlaceOrderResponse_QNAME, PlaceOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddRestaurantResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/Lunch", name = "addRestaurantResponse")
    public JAXBElement<AddRestaurantResponse> createAddRestaurantResponse(AddRestaurantResponse value) {
        return new JAXBElement<AddRestaurantResponse>(_AddRestaurantResponse_QNAME, AddRestaurantResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetMenuItemsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/Lunch", name = "getMenuItemsResponse")
    public JAXBElement<GetMenuItemsResponse> createGetMenuItemsResponse(GetMenuItemsResponse value) {
        return new JAXBElement<GetMenuItemsResponse>(_GetMenuItemsResponse_QNAME, GetMenuItemsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetRestaurantsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://localhost/Lunch", name = "getRestaurantsResponse")
    public JAXBElement<GetRestaurantsResponse> createGetRestaurantsResponse(GetRestaurantsResponse value) {
        return new JAXBElement<GetRestaurantsResponse>(_GetRestaurantsResponse_QNAME, GetRestaurantsResponse.class, null, value);
    }

}
