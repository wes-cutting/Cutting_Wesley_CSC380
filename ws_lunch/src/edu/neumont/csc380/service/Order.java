package edu.neumont.csc380.service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: user
 * Date: 8/9/13
 * Time: 3:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class Order {
    protected String studentName;
    protected String restaurantName;
    protected List<String> selections;

    public Order(){

    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public List<String> getSelections() {
        if(selections == null){
            selections = new ArrayList<String>();
        }
        return selections;
    }

    public void addSelection(String selection) {
        selections.add(selection);
    }
}
