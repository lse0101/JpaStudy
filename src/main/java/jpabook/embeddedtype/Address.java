package jpabook.embeddedtype;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * Created by lse0101 on 2017-02-17.
 */
@Embeddable
public class Address {

    @Column(name = "city")
    private String city;
    private String street;
    @Embedded
    private ZipCode zipcode;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public ZipCode getZipcode() {
        return zipcode;
    }

    public void setZipcode(ZipCode zipcode) {
        this.zipcode = zipcode;
    }
}
