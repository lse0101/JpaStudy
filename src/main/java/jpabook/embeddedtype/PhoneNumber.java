package jpabook.embeddedtype;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by lse0101 on 2017-02-17.
 */
@Embeddable
public class PhoneNumber {

    private String areaCode;
    private String localNumber;

    @ManyToOne
    @JoinColumn(name = "service_id")
    PhoneServiceProvider provider;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getLocalNumber() {
        return localNumber;
    }

    public void setLocalNumber(String localNumber) {
        this.localNumber = localNumber;
    }

    public PhoneServiceProvider getProvider() {
        return provider;
    }

    public void setProvider(PhoneServiceProvider provider) {
        this.provider = provider;
    }
}
