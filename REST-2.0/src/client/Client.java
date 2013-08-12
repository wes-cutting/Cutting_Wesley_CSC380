package client;

import jaxb.menu.Item;
import jaxb.order.Order;
import jaxb.restaurants.Restaurant;
import jaxb.restaurants.Restaurants;

import javax.xml.bind.JAXBContext;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/12/13
 * Time: 10:59 AM
 * To change this template use File | Settings | File Templates.
 */
public class Client {
    public static void main(String[] args) {
        try {
            URL restaurantsURL = new URL("http", "localhost", 8080, "/rest/restaurants");
            HttpURLConnection restaurantsConnection = (HttpURLConnection) restaurantsURL.openConnection();

            JAXBContext restaurantsContext = JAXBContext.newInstance(Restaurants.class);
            InputStream restaurantsInputStream = restaurantsConnection.getInputStream();
            Restaurants restaurants = (Restaurants) restaurantsContext.createUnmarshaller().unmarshal(restaurantsInputStream);
            restaurantsConnection.disconnect();

            for (Restaurant restaurant : restaurants.getRestaurant()) {
                System.out.println(restaurant.getId() + ") " + restaurant.getName());
            }
            Scanner scan = new Scanner(System.in);
            System.out.println("Pick a restaurant:");

            String input = scan.nextLine();

            URL menuURL = new URL("http", "localhost", 8080, "/rest/menu?restaurantId=" + input);
            HttpURLConnection menuConnection = (HttpURLConnection) menuURL.openConnection();

            JAXBContext menuContext = JAXBContext.newInstance(jaxb.menu.Restaurant.class);
            InputStream menuInputStream = menuConnection.getInputStream();
            jaxb.menu.Restaurant restaurant = (jaxb.menu.Restaurant) menuContext.createUnmarshaller().unmarshal(menuInputStream);
            menuConnection.disconnect();

            for (Item i : restaurant.getItem()){
                System.out.println((restaurant.getItem().indexOf(i)+1) + ") " + i.getName() + ": " + i.getPrice());
            }
            System.out.println("Pick an item:");
            int menuChoice = Integer.parseInt(scan.nextLine());

            System.out.println("How much would you like?");
            int quantity = Integer.parseInt(scan.nextLine());

            URL orderURL = new URL("http", "localhost", 8080, "/rest/menu?restaurantId=" + input);
            HttpURLConnection orderConnection = (HttpURLConnection) orderURL.openConnection();
            orderConnection.setDoOutput(true);
            orderConnection.setRequestMethod("POST");

            JAXBContext orderContext = JAXBContext.newInstance(Order.class);
            OutputStream orderOutputStream = orderConnection.getOutputStream();
            Order order = new Order();
            jaxb.order.Item item = new jaxb.order.Item();
            item.setPrice(restaurant.getItem().get(menuChoice-1).getPrice());
            item.setName(restaurant.getItem().get(menuChoice - 1).getName());
            item.setQuantity(BigInteger.valueOf(quantity));
            order.getItem().add(item);
            orderContext.createMarshaller().marshal(order, orderOutputStream);

            BufferedReader br = new BufferedReader(new InputStreamReader(orderConnection.getInputStream()));
            System.out.println(br.readLine());

            orderConnection.disconnect();



        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
