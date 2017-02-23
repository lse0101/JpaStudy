package jpabook.embeddedtype;

import javax.persistence.Embeddable;

/**
 * Created by lse0101 on 2017-02-17.
 */
@Embeddable
public class ZipCode {
    private String zip;
    private String plusFour;

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPlusFour() {
        return plusFour;
    }

    public void setPlusFour(String plusFour) {
        this.plusFour = plusFour;
    }
}
