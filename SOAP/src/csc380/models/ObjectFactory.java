
package csc380.models;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the csc380.models package.
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

    private final static QName _MenuItem_QNAME = new QName("", "menuItem");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.neumont.csc380.models
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Restaurant }
     * 
     */
    public Restaurant createRestaurant() {
        return new Restaurant();
    }

    /**
     * Create an instance of {@link Restaurants }
     * 
     */
    public Restaurants createRestaurants() {
        return new Restaurants();
    }

    /**
     * Create an instance of {@link javax.xml.bind.JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "menuItem")
    public JAXBElement<String> createMenuItem(String value) {
        return new JAXBElement<String>(_MenuItem_QNAME, String.class, null, value);
    }

}
