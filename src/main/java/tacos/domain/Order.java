package tacos.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.CreditCardNumber;

public class Order {

    private Long id;

    private Date placedAt;

    private ArrayList<Taco> tacos = new ArrayList<>();

    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "Street is required")
    private String street;
    @NotBlank(message = "City is required")
    private String city;
    @NotBlank(message = "State is required")
    private String state;
    @NotBlank(message = "Zip is required")
    private String zip;
    @CreditCardNumber(message = "Not a valid credit card number")
    private String ccNumber;
    @Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "Invalid CCV")
    private String ccCVV;

    public Order() {
    }

    public void addTaco(Taco taco) {
        this.getTacos().add(taco);
    }

    public List<Taco> getTacos() {
        return tacos;
    }

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the placedAt
     */
    public Date getPlacedAt() {
        return placedAt;
    }

    /**
     * @param placedAt the placedAt to set
     */
    public void setPlacedAt(Date placedAt) {
        this.placedAt = placedAt;
    }

    /**
     * @param tacos the tacos to set
     */
    public void setTacos(ArrayList<Taco> tacos) {
        this.tacos = tacos;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the street
     */
    public String getStreet() {
        return street;
    }

    /**
     * @param street the street to set
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the zip
     */
    public String getZip() {
        return zip;
    }

    /**
     * @param zip the zip to set
     */
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * @return the ccNumber
     */
    public String getCcNumber() {
        return ccNumber;
    }

    /**
     * @param ccNumber the ccNumber to set
     */
    public void setCcNumber(String ccNumber) {
        this.ccNumber = ccNumber;
    }

    /**
     * @return the ccExpiration
     */
    public String getCcExpiration() {
        return ccExpiration;
    }

    /**
     * @param ccExpiration the ccExpiration to set
     */
    public void setCcExpiration(String ccExpiration) {
        this.ccExpiration = ccExpiration;
    }

    /**
     * @return the ccCVV
     */
    public String getCcCVV() {
        return ccCVV;
    }

    /**
     * @param ccCVV the ccCVV to set
     */
    public void setCcCVV(String ccCVV) {
        this.ccCVV = ccCVV;
    }

}
