package edu.neumont.csc380.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/9/13
 * Time: 3:33 PM
 * To change this template use File | Settings | File Templates.
 */
public class Restaurant {
    protected List<String> menuItems;
    protected String name;

    public List<String> getMenuItems() {
        if (menuItems == null) {
            menuItems = new ArrayList<String>();
        }
        return this.menuItems;
    }

    public void addMenuItem(String item){
        getMenuItems().add(item);
    }

    public String getName() {
        return name;
    }

    public void setName(String value) {
        this.name = value;
    }
}
