package util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/12/13
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class RestaurantData {
    private static final Map<Integer, Restaurant> Restaurants;

    static{
        Restaurants = new HashMap() ;
        // Add Restaurant Data
    }

    // Helper methods for updating data

    public static class Restaurant {
       private List<Item> items;

        private List<Item> getItems() {
            return items;
        }

        private void setItems(List<Item> items) {
            this.items = items;
        }
    }

    public static class Item{
        String name;
        double price;

        private String getName() {
            return name;
        }

        private void setName(String name) {
            this.name = name;
        }

        private double getPrice() {
            return price;
        }

        private void setPrice(double price) {
            this.price = price;
        }
    }
}
