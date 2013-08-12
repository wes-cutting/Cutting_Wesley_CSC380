package client;

import jaxb.restaurants.Restaurant;
import jaxb.restaurants.Restaurants;

import javax.xml.bind.JAXBContext;
import java.io.InputStream;
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

            JAXBContext menuContext = JAXBContext.newInstance(Restaurants.class);
            InputStream menuInputStream = menuConnection.getInputStream();
            Restaurant restaurant = (Restaurant) menuContext.createUnmarshaller().unmarshal(menuInputStream);

            restaurant.

            //menuConnection.setRequestMethod("POST");

        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

    }
}
