package csc380.service;

import csc380.jaxb.request.Envelope;
import csc380.jaxb.response.Food;
import csc380.jaxb.response.Restaurant;
import csc380.jaxb.response.RestaurantResponse;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;

@WebServlet(name = "RequestServlet", urlPatterns = "/restaurant")
public class RequestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            JAXBContext jaxb = JAXBContext.newInstance("csc380.jaxb.request");
            Unmarshaller requestUnmarshaller = jaxb.createUnmarshaller();
            csc380.jaxb.post.request.Envelope requestEnvelope = (csc380.jaxb.post.request.Envelope) requestUnmarshaller.unmarshal(request.getInputStream());

            response.getWriter().write("Order successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/xml");
            JAXBContext jaxb = JAXBContext.newInstance("csc380.jaxb.response");
            Unmarshaller soapRequestUnmarshaller = jaxb.createUnmarshaller();
            Envelope soapRequestEnvelope = (Envelope) soapRequestUnmarshaller.unmarshal(request.getInputStream());
            Marshaller m = jaxb.createMarshaller();
            csc380.jaxb.response.Envelope responseEnvelope = new csc380.jaxb.response.Envelope();
            csc380.jaxb.response.Body responseBody = new csc380.jaxb.response.Body();
            RestaurantResponse restaurantResponse = new RestaurantResponse();
            Restaurant r = new Restaurant();
            r.setName("Red Hot");
            r.getFood().add(new Food());
            restaurantResponse.setRestaurant(r);
            responseBody.setRestaurantResponse(restaurantResponse);
            responseEnvelope.setBody(responseBody);

            m.marshal(responseEnvelope, response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
