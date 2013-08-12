
package csc380.jaxb.request;

import javax.xml.bind.annotation.*;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://neumont.edu/wcutting/lunch/restaurant}GetRestaurants"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getRestaurants"
})
@XmlRootElement(name = "Body", namespace = "http://www.w3.org/2001/12/soap-envelope")
public class Body {

    @XmlElement(name = "GetRestaurants", namespace = "http://neumont.edu/wcutting/lunch/restaurant", required = true)
    protected GetRestaurants getRestaurants;

    /**
     * Gets the value of the getRestaurants property.
     * 
     * @return
     *     possible object is
     *     {@link GetRestaurants }
     *     
     */
    public GetRestaurants getGetRestaurants() {
        return getRestaurants;
    }

    /**
     * Sets the value of the getRestaurants property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetRestaurants }
     *     
     */
    public void setGetRestaurants(GetRestaurants value) {
        this.getRestaurants = value;
    }

}
